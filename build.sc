import mill._
import mill.scalalib._

object nested extends TestModule with ScalaModule {

    def scalaVersion = "2.12.11"

    override def testFrameworks = Seq("org.scalatest.tools.Framework")

    override def ivyDeps = T { super.ivyDeps() ++ Agg(
      ivy"org.scalatest::scalatest:3.1.1"
    )}
}

