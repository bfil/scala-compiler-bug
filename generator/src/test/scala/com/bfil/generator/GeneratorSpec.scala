package com.bfil.generator

import org.specs2.mutable.Specification

class GeneratorSpec extends Specification {

  val someValue = 1

  "Generator" should {

    val anotherValue = 2
    def sayHello() = "hello"

    "generate something with a macro" in {

      // This compiles on Scala 2.11 but on 2.12 fails with:
      // assertion failed: Trying to access the this of another class: tree.symbol = class GeneratorSpec, class symbol = <$anon: com.bfil.generator.Scope> compilation unit: GeneratorSpec.scala
      Generator.generate { () =>
        someValue
      }

      // This compiles on Scala 2.11 but on 2.12 fails with:
      // key not found: value anotherValue$1
      Generator.generate { () =>
        anotherValue
      }

      // This compiles as expected on both Scala 2.11 and 2.12
      Generator.generate { () =>
        sayHello()
      }

      true === true

    }

  }

}
