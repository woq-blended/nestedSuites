package nested

import org.scalatest.Suite
import org.scalatest.freespec.AnyFreeSpec

import scala.collection.immutable.IndexedSeq

class NestedSuitesSpec extends AnyFreeSpec {


  "A nested suite should" - {

    "execute a given test" in {
      assert(true)
    }
  }

  override def nestedSuites: IndexedSeq[Suite] = IndexedSeq(
    new ANestedSuite(5)
  )
}
