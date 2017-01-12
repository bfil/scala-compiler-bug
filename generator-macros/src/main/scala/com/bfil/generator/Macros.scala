package com.bfil.generator

import scala.reflect.macros.blackbox.Context

trait Scope {}

object Macros {
  def materializeImpl[T: c.WeakTypeTag](c: Context)(generator: c.Expr[() => T]): c.Expr[Unit] = {
    import c.universe._
    c.Expr[Unit](q"""
      new Scope {
        $generator()
      }
    """)
  }
}
