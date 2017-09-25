
using System;
using Xunit;

namespace calculadora_posfixa
{

    public class CalculadoraTest
    {

        [Fact]
        public void ExampleTest()
        {

            Assert.True(true);

            Assert.Throws(
                typeof(Exception),
                () => throw new Exception()
            );

        }

    }

}
