package sorting


import org.scalameter.measure

import scala.util.Random
import sort._


object comparision extends App  {
val xs = ((1 until 10 ) map (x => Random.nextInt(10))).toList

def msortmeasure(n:Int)= {
  val xs = ((1 until n ) map (x => Random.nextInt(n))).toList
  mergesort(xs)
}
  def bsortmeasure(n:Int)= {
    val xs = ((1 until n ) map (x => Random.nextInt(n))).toArray
    bubblesort(xs)
//    println(xs.toList)
  }

  def ssortmeasure(n:Int)= {
    val xs = ((1 until n ) map (x => Random.nextInt(n))).toArray
    selectionsort(xs)
  }



  val msorttime = measure {
    msortmeasure(1000)
  }
  println(s"Array merge sort time : $msorttime ms")

  val bsorttime = measure {
    bsortmeasure(10)

  }
  println(s"Array bubble sort time : $bsorttime ms")


  val ssortm = measure {
    ssortmeasure(10)
  }

  println(s"Array selection sort time : $ssortm ms")

}
