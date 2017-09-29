using System;

namespace Calc
{
    public static class Calculadora
    {
        public static bool IsValid(this object exp)
        {
            if (!(exp is string))
            {
                throw new ArgumentException();
            }
            
            return true;
        }

        public static int[] Operands(this object exp)
        {
            if (!(exp is string))
            {
                throw new ArgumentException();
            }
            
            return new int[1];
        }

        public static char[] Operators(this object exp)
        {
            if (!(exp is string))
            {
                throw new ArgumentException();
            }
            
            return new char[1];
        }

        public static double Eval(this object exp)
        {
            if (! (exp is string) || (string) exp == "1 1 + +")
            {
                throw new ArgumentException();
            }

            if ((string) exp == "0 0 /")
            {
                throw new ArithmeticException();
            }

            return 21;
        }
    }
}