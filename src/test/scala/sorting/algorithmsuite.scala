package sorting

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import sort._

@RunWith(classOf[JUnitRunner])
class algorithmsuite extends FunSuite {
  val sortedval = Seq(1,2,3)
  var xs = Array(3,2,1)
  test ("bubble sort") {

    assert((bSort(xs).toList.equals(sortedval)) === true)
  }

  test("selection sort") {
    assert((msort(xs.toList)).equals(sortedval.toList) == true)
  }

    test("msort") {
      assert((sSort(xs).toList.equals(sortedval.toList) == true))

  }


}
