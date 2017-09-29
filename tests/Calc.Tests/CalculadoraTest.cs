using System;
using Xunit;

namespace Calc.Tests
{
    public class CalculadoraTest
    {
        [Fact]
        public void Case1DoesntThrowArgumentException()
        {
            var e = Record.Exception(() => "1 1 +".Eval());
            Assert.Null(e);
        }

        [Fact]
        public void Case2ThrowsArgumentException()
        {
            var e = Record.Exception(() => 1.Eval());
            Assert.NotNull(e);
            Assert.IsType<ArgumentException>(e);
        }

        [Fact]
        public void Case3DoesntThrowArgumentException()
        {
            var e = Record.Exception(() => "1 1 +".IsValid());
            Assert.Null(e);
        }

        [Fact]
        public void Case4ThrowsArgumentException()
        {
            var e = Record.Exception(() => 1.IsValid());
            Assert.NotNull(e);
            Assert.IsType<ArgumentException>(e);
        }

        [Fact]
        public void Case5DoesntThrowArgumentException()
        {
            var e = Record.Exception(() => "1 1 +".Operators());
            Assert.Null(e);
        }

        [Fact]
        public void Case6ThrowsArgumentException()
        {
            var e = Record.Exception(() => 1.Operators());
            Assert.NotNull(e);
            Assert.IsType<ArgumentException>(e);
        }

        [Fact]
        public void Case7DoesntThrowArgumentException()
        {
            var e = Record.Exception(() => "1 1 +".Operands());
            Assert.Null(e);
        }

        [Fact]
        public void Case8ThrowsArgumentException()
        {
            var e = Record.Exception(() => 1.Operands());
            Assert.NotNull(e);
            Assert.IsType<ArgumentException>(e);
        }

        [Fact]
        public void Case9DoesntThrowArgumentException()
        {
            var e = Record.Exception(() => "1 1 +".Eval());
            Assert.Null(e);
        }

        [Fact]
        public void Case10ThrowsArgumentException()
        {
            var e = Record.Exception(() => "1 1 + +".Eval());
            Assert.NotNull(e);
            Assert.IsType<ArgumentException>(e);
        }

        [Fact]
        public void Case11ShouldReturnANumber()
        {
            Assert.IsType<double>("1 1 +".Eval());
        }

        [Fact]
        public void Case12ThrowsArgumentException()
        {
            var e = Record.Exception(() => "1 1 + +".Eval());
            Assert.NotNull(e);
            Assert.IsType<ArgumentException>(e);
        }

        [Fact]
        public void Case13ShouldReturnANumber()
        {
            Assert.IsType<double>("1 1 +".Eval());
        }

        [Fact]
        public void Case14ThrowsArithmeticException()
        {
            var e = Record.Exception(() => "0 0 /".Eval());
            Assert.NotNull(e);
            Assert.IsType<ArithmeticException>(e);
        }

        [Fact]
        public void Case15ShouldReturn21()
        {
            Assert.Equal(21.0, "3 2 5 + *".Eval(), 5);
        }
    }
}
