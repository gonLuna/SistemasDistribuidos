package CalculadoraApp;

/**
* CalculadoraApp/CalculadoraHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculadora.idl
* jueves 5 de noviembre de 2015 20H05' COT
*/

public final class CalculadoraHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculadoraApp.Calculadora value = null;

  public CalculadoraHolder ()
  {
  }

  public CalculadoraHolder (CalculadoraApp.Calculadora initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculadoraApp.CalculadoraHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculadoraApp.CalculadoraHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculadoraApp.CalculadoraHelper.type ();
  }

}
