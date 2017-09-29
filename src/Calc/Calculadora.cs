using System;

namespace Calc
{
    public static class Calculadora
    {
        public static bool IsValid(this object exp)
        {
            throw new NotImplementedException();
        }

        public static int[] Operands(this object exp)
        {
            throw new NotImplementedException();
        }

        public static char[] Operators(this object exp)
        {
            throw new NotImplementedException();
        }

        public static double Eval(this object exp)
        {
            if (! (exp is string))
            {
                throw new ArgumentException();
            }
            
            return double.NaN;
        }
    }
}