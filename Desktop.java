class Company
{
	int n;
	boolean Trigger = true;
	synchronized public void produce_item(int n)throws Exception
	{
		if(Trigger)
		{
			wait();
		}
		this.n=n;
		System.out.println("Produced : "+this.n);
		Trigger=false;
		notify();
	}

	synchronized public int consume_item()throws Exception
	{
		if(!Trigger)
		{
			wait();
		}
		System.out.println("Consumed : "+this.n);
		Trigger = true;
		notify();
		return this.n;
	}
}