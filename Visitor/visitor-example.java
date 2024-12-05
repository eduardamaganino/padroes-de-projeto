public interface IElement
{
   void Accept(IVisitor visitor);
}

public class ConcreteElementA : IElement
    {
        public void Accept(IVisitor visitor)
        {
            visitor.VisitConcreteElementA(this);
        }public string ExclusiveMethodOfConcreteElementA()
        {
            return "A";
        }
    }

public class ConcreteElementB : IElement
    {
        public void Accept(IVisitor visitor)
        {
            visitor.VisitConcreteElementB(this);
        }public string SpecialMethodOfConcreteElementB()
        {
            return "B";
        }
    }

public interface IVisitor
    {
        void VisitConcreteElementA(ConcreteElementA element);void VisitConcreteElementB(ConcreteElementB element);
    }

class ConcreteVisitor1 : IVisitor
    {
        public void VisitConcreteElementA(ConcreteElementA element)
        {
            Console.WriteLine($"{element.ExclusiveMethodOfConcreteElementA()} ConcreteVisitor1");
        }public void VisitConcreteElementB(ConcreteElementB element)
    {
        Console.WriteLine($"{element.SpecialMethodOfConcreteElementB()} ConcreteVisitor1");
        }
    }

class ConcreteVisitor2 : IVisitor
    {
        public void VisitConcreteElementA(ConcreteElementA element)
        {
            Console.WriteLine($"{element.ExclusiveMethodOfConcreteElementA()} ConcreteVisitor2");
        }public void VisitConcreteElementB(ConcreteElementB element)
        {
            Console.WriteLine($"{element.SpecialMethodOfConcreteElementB()} ConcreteVisitor2");
        }
    }

class Program
    {
        static void Main(string[] args)
        {
            List<IElement> components = new List<IElement>
            {
                new ConcreteElementA(),
                new ConcreteElementB()
            };Console.WriteLine("The client code works with all visitors via the base Visitor interface:");
            var visitor1 = new ConcreteVisitor1();
            Client.ClientCode(components, visitor1);Console.WriteLine();Console.WriteLine("It allows the same client code to work with different types of visitors:");
            var visitor2 = new ConcreteVisitor2();
            Client.ClientCode(components, visitor2);Console.WriteLine("Press any key to continue!");
            Console.ReadKey();
        }
    }