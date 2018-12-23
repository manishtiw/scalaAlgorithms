//def fact(n:Long):Long = if(n<2) 1L else n*fact(n-1)
//import algorithms.sort
//import algorithms.sort.sSort
import org.scalameter.measure

import scala.util.Random


//var xs = Array(1,2,3)
//xs.length

def sSort[T](xs: Array[T])(implicit ord: Ordering[T]): Array[T] = {
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


var xs = ((1 until 10 ) map (x => Random.nextInt(10))).toArray

def ssortmeasure(n:Int)= {
  val xs = ((1 until n ) map (x => Random.nextInt(n))).toArray
  sSort(xs)
}


val ssortval = measure {
  ssortmeasure(1000)
}