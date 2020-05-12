import mill._
import mill.scalalib._

object nested extends SbtModule {

  def scalaVersion = "2.13.2"

  object test extends Tests {

    override def testFrameworks = Seq("org.scalatest.tools.Framework")

    override def ivyDeps = T { super.ivyDeps() ++ Agg(
      ivy"org.scalatest::scalatest:3.1.1"
    )}
  }
}

