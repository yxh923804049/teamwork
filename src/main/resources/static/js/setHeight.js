// JavaScript Document

$(document).ready( 			function(){
						   x=$(window).width();
						   y=$(window).height();
						   if(x<=y)
						   {
						   $("td").css("width",x/6)
						          .css("height",x/6);
						   }
						   else
						   {
							   $("td").css("width",y/6)
						          .css("height",y/6);
						   }
						   
				});
  num=new Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
					i=Math.floor(Math.random()*16);
					num[i]=2;
					i=Math.floor(Math.random()*16);
					num[i]=2;
					strArr=num.toString();
					ga(strArr);
					donum();