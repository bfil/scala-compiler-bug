package com.bfil.generator

object Generator {
  import scala.language.experimental.macros
  def generate[T](generator: () => T): Unit = macro Macros.materializeImpl[T]
}
