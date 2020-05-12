package nested

import org.scalatest.{Args, Status}
import org.scalatest.freespec.AnyFreeSpec

/* The constructor parameter causes that this test suite cannot be discovered
   automatically.
 */
class ANestedSuite(dummy : Int) extends AnyFreeSpec {

  "The nested suites should" - {

    "also be exectuted" in {
      assert(true)
    }
  }

  override def run(testName: Option[String], args: Args): Status = {
    super.run(testName, args)
  }
}
