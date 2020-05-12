import mill._
import mill.modules.Jvm
import mill.scalalib._

object nested extends SbtModule {

  def scalaVersion = "2.13.2"

  object test extends Tests {

    override def testFrameworks = Seq("org.scalatest.tools.Framework")

    override def ivyDeps = T { super.ivyDeps() ++ Agg(
      ivy"org.scalatest::scalatest:3.1.1"
    )}

    def itest() = T.command {

      val dir = T.dest

      Jvm.runSubprocess(
        mainClass = "org.scalatest.tools.Runner",
        classPath = runClasspath().map(_.path),
        mainArgs = Seq(
          "-R", compile().classes.path.toIO.getAbsolutePath(),
          //"-u", dir.toIO.getAbsolutePath(),
          "-o"
        )
      )

      PathRef(dir)
    }
  }
}

