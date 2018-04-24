/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.framework.domain;

import javax.persistence.Embeddable;

/**
 * a generic range class.
 *
 * @param <T>
 * @author Paulo Gandra Sousa
 */
@Embeddable
public class Range<T extends Comparable<T>> implements ValueObject {

	private static final long serialVersionUID = 1L;
	private T start;
	private T end;
	private boolean openStart;
	private boolean openEnd;
	private RangeInfinityType infinityType = null;

	protected Range() {
		// for ORM
	}

	/**
	 * constructs a range
	 *
	 * @param start     start of the range
	 * @param end       end of the range
	 * @param openStart indicates if the range is open at the start
	 * @param openEnd   indicates if the range is open at the end
	 */
	public Range(T start, T end, boolean openStart, boolean openEnd) {
		if (start == null || end == null) {
			throw new IllegalArgumentException("start or end must be non-null");
		}
		if (end.compareTo(start) < 0) {
			throw new IllegalStateException("The end value of a range must be bigger than its start");
		}
		if (end.compareTo(start) == 0 && (openEnd || openStart)) {
			throw new IllegalStateException("An empty range is not allowed");
		}

		this.start = start;
		this.end = end;
		this.openStart = openStart;
		this.openEnd = openEnd;
		this.infinityType = RangeInfinityType.NONE;
	}

	/**
	 * constructs an "infinity-unbound" range
	 *
	 * @param anchor       the anchor value to use as one of the extremes of the range
	 * @param open         true if the range is open on that extreme
	 * @param infinityType defines the unbound end of the range, either
	 *                     "negative infinity" or "positive infinity"
	 */
	public Range(T anchor, boolean open, RangeInfinityType infinityType) {
		if (infinityType == RangeInfinityType.NONE) {
			throw new IllegalStateException(
					"You are not allowed to create an infinity range NONE using the constructor.");
		}

		if (infinityType == RangeInfinityType.TO_INFINITY) {
			this.start = anchor;
			this.end = anchor; // dummy
			this.openStart = open;
			this.openEnd = false;
		} else {
			assert infinityType == RangeInfinityType.FROM_INFINITY;
			this.start = anchor; // dummy
			this.end = anchor;
			this.openStart = false;
			this.openEnd = open;
		}
		this.infinityType = infinityType;
	}

	/**
	 * a factory method for open ranges
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static <T extends Comparable<T>> Range<T> openRange(T start, T end) {
		return new Range<>(start, end, true, true);
	}

	/**
	 * a factory method for closed ranges
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static <T extends Comparable<T>> Range<T> closedRange(T start, T end) {
		return new Range<>(start, end, false, false);

	}

	/**
	 * A factory method for ranges that go until "positive infinity"
	 *
	 * @param start
	 * @param openStart
	 * @return
	 */
	public static <T extends Comparable<T>> Range<T> toInfinity(T start, boolean openStart) {
		return new Range<>(start, openStart, RangeInfinityType.TO_INFINITY);
	}

	/**
	 * A factory method for ranges that start at "negative infinity"
	 *
	 * @param end
	 * @param openEnd
	 * @return
	 */
	public static <T extends Comparable<T>> Range<T> fromInfinity(T end, boolean openEnd) {
		return new Range<>(end, openEnd, RangeInfinityType.FROM_INFINITY);
	}

	/**
	 * a factory method for open ended ranges
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static <T extends Comparable<T>> Range<T> openEnded(T start, T end) {
		return new Range<>(start, end, false, true);
	}

	/**
	 * checks if a value belongs in this range
	 *
	 * @param target
	 * @return
	 */
	public boolean includes(T target) {
		switch (this.infinityType) {
			case NONE:
				return includesOfNormalRanges(target);
			case TO_INFINITY:
				return includesOfToInfinityRanges(target);
			default:
				assert this.infinityType == RangeInfinityType.FROM_INFINITY;
				return includesOfFromInfinityRanges(target);
		}
	}

	private boolean includesOfFromInfinityRanges(T target) {
		if (target.compareTo(this.end) > 0) {
			return false;
		}
		return !(this.openEnd && target.compareTo(this.end) == 0);
	}

	private boolean includesOfToInfinityRanges(T target) {
		if (target.compareTo(this.start) < 0) {
			return false;
		}
		return !(this.openStart && target.compareTo(this.start) == 0);
	}

	private boolean includesOfNormalRanges(T target) {
		if (target.compareTo(this.start) < 0 || target.compareTo(this.end) > 0) {
			return false;
		}
		if (this.openStart && target.compareTo(this.start) == 0) {
			return false;
		}
		return !(this.openEnd && target.compareTo(this.end) == 0);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(startBracket(this.openStart));
		sb.append(rangeValue(this.isFromInfinity(), this.start));
		sb.append(", ");
		sb.append(rangeValue(this.isToInfinity(), this.end));
		sb.append(startBracket(this.openEnd));
		return sb.toString();
	}

	public boolean isToInfinity() {
		return this.infinityType == RangeInfinityType.TO_INFINITY;
	}

	public boolean isFromInfinity() {
		return this.infinityType == RangeInfinityType.FROM_INFINITY;
	}

	public T start() {
		return this.start;
	}

	public T end() {
		return this.end;
	}

	private char startBracket(boolean isOpen) {
		if (isOpen) {
			return ']';
		} else {
			return '[';
		}
	}

	private char endBracket(boolean isOpen) {
		if (isOpen) {
			return '[';
		} else {
			return ']';
		}
	}

	private String rangeValue(boolean isInfinity, T value) {
		if (isInfinity) {
			return "oo";
		} else {
			return value.toString();
		}
	}
}
