package nested

import org.scalatest.DoNotDiscover
import org.scalatest.freespec.AnyFreeSpec

class ANestedSuite(dummy : Int) extends AnyFreeSpec {

  "The nested suites should" - {

    "also be exectuted" in {
      assert(true)
    }
  }
}
