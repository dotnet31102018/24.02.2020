using EasyNetQ;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Rabbit
{
    // Requires EasyNetQ nugget!!!!
    // Requires NewtonSoft (should be already downloaded inside EasyNetQ)
    class Program
    {
        static void SendMessage()
        {
            using (var bus = RabbitHutch.CreateBus("host=localhost"))
            {
                Console.WriteLine("Press any key to send the message");
                Thread.Sleep(1500);
                bus.Publish("{\"text\": \"Hello World\"}", "My_Game");
                Console.WriteLine("Message sent ... Press any key to quit");
            }
        }
        static void Listen()
        {
            using (var bus = RabbitHutch.CreateBus("host=localhost"))
            {
                //Console.WriteLine("press key to start listening");
                //Console.ReadKey();
                bus.Subscribe<string>("My_Game", HandleClusterNodes);
                Console.WriteLine("Listening ...Press any key to quit");
                Console.ReadKey();
            }
        }

        private static void HandleClusterNodes(string obj)
        {
            Console.WriteLine(obj);
        }

        static void Main(string[] args)
        {
            //Task.Run(() => { Listen(); })   ;
            Thread.Sleep(1000);
            SendMessage();
            SendMessage();
        }

        public class MessageA
        {
            public string Text { get; set; }
        }
    }
}
