// JavaScript Document
getArr=new Array();
function ga(str)
{
	getArr = str.split(",");
}

function donum()
{
	for(i=0;i<16;i++)
	{
		if(getArr[i]!=0)
		{
			document.getElementById(i).innerText=getArr[i];
		}
		else
		{
			document.getElementById(i).innerText="";
		}
	}
	
}

function randnum()
{
	var num;
	for(j=0;j<16;j++)
	{
		if(getArr[j]!=0)
		{
			num++;
		}
	}
	if(num!=16)
	{
		while(1)
		{
			i=Math.floor(Math.random()*16);
			if(getArr[i]==0)
			{
				var rn=Math.ceil(Math.random()*10);
				if(rn>0&&rn<=6)
				{
					getArr[i]=2;
				}
				else if(rn>6&&rn<=9)
				{
					getArr[i]=4;
				}
				else
				{
					getArr[i]=8;
				}
					
				break;
			}
		}
	}
		donum();
}
function down()
{
	for(var num=12;num<=15;num++)
	{
		if(getArr[num]==getArr[num-4])
		{
			getArr[num]=parseInt(getArr[num-4])+parseInt(getArr[num]);
			getArr[num-4]=0;
			if(getArr[num-8]==getArr[num-12])
			{
				getArr[num-8]=parseInt(getArr[num-8])+parseInt(getArr[num-12]);
				getArr[num-12]=0;
			}
		}
		else if(getArr[num-4]==getArr[num-8])
		{
			getArr[num-4]=parseInt(getArr[num-8])+parseInt(getArr[num-4]);
			getArr[num-8]=0;
		}
		else if(getArr[num-8]==getArr[num-12])
		{
			getArr[num-8]=parseInt(getArr[num-12])+parseInt(getArr[num-8]);
			getArr[num-12]=0;
		}
		
		
		for(var j=num;j>=num-8;j=j-4)
		{
			if(getArr[j]==0)
			{
				for(var i=j-4;i>=0;i=i-4)
				{
					if(getArr[i]!=0)
					{
						getArr[j]=getArr[i];
						getArr[i]=0;
						break;
					}
				}
			}
		}
		
	}
	donum();
	randnum();
}


function up()
{
	for(var num=3;num>=0;num--)
	{
		if(getArr[num]==getArr[num+4])
		{
			getArr[num]=parseInt(getArr[num+4])+parseInt(getArr[num]);
			getArr[num+4]=0;
			if(getArr[num+8]==getArr[num+12])
			{
				getArr[num+8]=parseInt(getArr[num+8])+parseInt(getArr[num+12]);
				getArr[num+12]=0;
			}
		}
		else if(getArr[num+4]==getArr[num+8])
		{
			getArr[num+4]=parseInt(getArr[num+8])+parseInt(getArr[num+4]);
			getArr[num+8]=0;
		}
		else if(getArr[num+8]==getArr[num+12])
		{
			getArr[num+8]=parseInt(getArr[num+12])+parseInt(getArr[num+8]);
			getArr[num+12]=0;
		}
		
		
		for(var j=num;j<=num+8;j=j+4)
		{
			if(getArr[j]==0)
			{
				for(var i=j+4;i<=15;i=i+4)
				{
					if(getArr[i]!=0)
					{
						getArr[j]=getArr[i];
						getArr[i]=0;
						break;
					}
				}
			}
		}
		
	}
	donum();
	randnum();
}


function right()
{
	for(var num=15;num>=3;num=num-4)
	{
		if(getArr[num]==getArr[num-1])
		{
			getArr[num]=parseInt(getArr[num-1])+parseInt(getArr[num]);
			getArr[num-1]=0;
			if(getArr[num-2]==getArr[num-3])
			{
				getArr[num-2]=parseInt(getArr[num-2])+parseInt(getArr[num-3]);
				getArr[num-3]=0;
			}
		}
		else if(getArr[num-1]==getArr[num-2])
		{
			getArr[num-1]=parseInt(getArr[num-2])+parseInt(getArr[num-1]);
			getArr[num-2]=0;
		}
		else if(getArr[num-2]==getArr[num-3])
		{
			getArr[num-2]=parseInt(getArr[num-3])+parseInt(getArr[num-2]);
			getArr[num-3]=0;
		}
		
		for(var j=num;j>=num-2;j=j-1)
		{
			if(getArr[j]==0)
			{
				for(var i=j-1;i>=num-3;i=i-1)
				{
					if(getArr[i]!=0)
					{
						getArr[j]=getArr[i];
						getArr[i]=0;
						break;
					}
				}
			}
		}
	}
	donum();
	randnum();
}
function left()
{
	for(var num=0;num<=12;num=num+4)
	{
		if(getArr[num]==getArr[num+1])
		{
			getArr[num]=parseInt(getArr[num+1])+parseInt(getArr[num]);
			getArr[num+1]=0;
			if(getArr[num+2]==getArr[num+3])
			{
				getArr[num+2]=parseInt(getArr[num+2])+parseInt(getArr[num+3]);
				getArr[num+3]=0;
			}
		}
		else if(getArr[num+1]==getArr[num+2])
		{
			getArr[num+1]=parseInt(getArr[num+2])+parseInt(getArr[num+1]);
			getArr[num+2]=0;
		}
		else if(getArr[num+2]==getArr[num+3])
		{
			getArr[num+2]=parseInt(getArr[num+3])+parseInt(getArr[num+2]);
			getArr[num+3]=0;
		}
		
		for(var j=num;j<=num+2;j=j+1)
		{
			if(getArr[j]==0)
			{
				for(var i=j+1;i<=num+3;i=i+1)
				{
					if(getArr[i]!=0)
					{
						getArr[j]=getArr[i];
						getArr[i]=0;
						break;
					}
				}
			}
		}
	}
	donum();
	randnum();
}