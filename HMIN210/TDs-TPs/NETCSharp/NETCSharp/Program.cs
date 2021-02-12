using System;
using Librairie;
using System.Collections.Generic;
namespace NETCSharp
{
	public class Complexe
	{
		private double reel;
		private double imaginaire;
		public Complexe(double reel, double imaginaire)
		{
			this.reel = reel;
			this.imaginaire = imaginaire;
		}
		public static Complexe operator +(Complexe a, Complexe b) => new Complexe(a.reel + b.reel, a.imaginaire + b.imaginaire);
		public static Complexe operator -(Complexe a, Complexe b) => new Complexe(a.reel - b.reel, a.imaginaire - b.imaginaire);
		public static Complexe operator *(Complexe a, Complexe b) => new Complexe((a.reel * b.reel) - (a.imaginaire * b.imaginaire), (a.reel * b.imaginaire) + (a.imaginaire * b.reel));
		
		static void Main(string[] args)
		{
			Complexe c1 = new Complexe(1, 2);
			Complexe c2 = new Complexe(2, 3);
			Console.WriteLine((c1 * c2).reel);
			Console.WriteLine((c1 * c2).imaginaire);
			Console.ReadKey();
		}
	}
}
