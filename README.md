Scala 2.12 - Macro Compiler Bug
===============================

This repository is just a simple showcase of a possible compiler bug in Scala 2.12

Scopes created within a macro are unable to reference values from outside their scope

To see the issue at play:

Clone the repo and run `sbt +test`

The test will compile and run fine with Scala 2.11.8, but compilation will fail on Scala 2.12.1
