package sorting
/** The implementation tries to give more functional approach towards 
  * common sorting algorithms
  * Three sorting algorithm are implemented below.
  * merge sort,bubble sort, selection sort
  */

object sort {

  def mergesort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(ys1, xs)
      }

      val (fst, snd) = xs splitAt (n)
      merge(mergesort(fst), mergesort(snd))
    }
  }

  def bubblesort[T](xs: Array[T])(implicit ord: Ordering[T]):Array[T] = {
    for (q <- (0 until xs.length - 1); p <- (0 until xs.length - 1 - q)) {
      if (ord.gt(xs(p), xs(p + 1))) {
        val tmp = xs(p)
        xs(p) = xs(p + 1)
        xs(p + 1) = tmp
      }
    }
    xs
  }


  def selectionsort[T](xs: Array[T])(implicit ord: Ordering[T]): Array[T] = {
    for (j <- 0 until xs.length - 1) {
      var min = j
      for (i <- j + 1 until xs.length) {
        if (ord.lt(xs(i), xs(min))) min = i
      }
      if (min != j) {
        val tmp = xs(j)
        xs(j) = xs(min)
        xs(min) = tmp
      }
    }
    xs
  }

  def shsort[T](xs:Array[T]) (implicit ord: Ordering[T]): Array[T] =  {
    var len=xs.length/2
    while(len>=1) {
      for(j <- len until xs.length) {
        var i=j-len
        val tmp=xs(j)
        while(i>=0 && ord.gt(xs(i),tmp)) {
          xs(i+len) = xs(i)
          i -= len
        }
        xs(i+len) = tmp
      }
      len=(len/2.2).round.toInt
    }
    xs
  }
}
