package nested

import org.scalatest.{Args, Status, Suite}
import org.scalatest.freespec.AnyFreeSpec

import scala.collection.immutable.IndexedSeq

class NestedSuitesSpec extends AnyFreeSpec {


  "A nested suite should" - {

    "execute a given test" in {
      assert(true)
    }
  }


  override def run(testName: Option[String], args: Args): Status = {
    super.run(testName, args)
  }


  override protected def runNestedSuites(args: Args): Status = {
    super.runNestedSuites(args)
  }

  override def nestedSuites: IndexedSeq[Suite] = IndexedSeq(
    new ANestedSuite(5)
  )
}
