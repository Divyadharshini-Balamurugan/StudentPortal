package student;
import java.sql.*;
import java.util.Scanner;

public class studentport {
	
public static int validate(int Roll) {
		
	    int num=0,count=0;
	    try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			//here studentportal is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from student"); 
			while(rs.next()) {
				num =rs.getInt("Roll_No");
				if(num == Roll) 
					count=count+1;
			}
			if(count==0)
				System.out.println("Roll_No is out of bound");
	}catch(Exception e){ System.out.println(e);}  
	     return count;
			
	}

public static int validate(String code) {
	
    String cod = "null";
    int count=0;
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/studentportal","root","");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from subject"); 
		while(rs.next()) {
			cod =rs.getString("Code");
        if(code.equalsIgnoreCase(cod))
				count=count+1;
		}
		if(count==0) {
			System.out.println("Subject_code is not found");}
}catch(Exception e){ System.out.println(e);}  
    return count;
	
}
	
public static int CheckLock(String code,String smt) {
	int cod = 0;
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/studentportal","root","");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select "+smt+" from locktable WHERE Subject_Code = '"+code+"'"); 
		while(rs.next()) 
			cod =rs.getInt(smt);
		if(cod==1) {
			System.out.println(smt+"are already LOCKED for Subject Code "+code);
		}
}catch(Exception e){ System.out.println(e);}  
    return cod;
	
}
	

public static void Detail(int Roll) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from student where Roll_No ="+Roll); 
			ResultSetMetaData rsmd = rs.getMetaData();
			int col=rsmd.getColumnCount();
			for(int i=1;i<=col;i++){
				System.out.print(rsmd.getColumnName(i)+"\t\t");
			}
			System.out.print("\n");
			while(rs.next()) 
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t\t"+rs.getString(7)+"\t\t"+rs.getString(8)); 
			con.close();  
		  }catch(Exception e){ System.out.println(e);}  
}
	
	
	public static void View(String stmnt) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(stmnt);

			ResultSetMetaData rsmd = rs.getMetaData();
			int col=rsmd.getColumnCount();
			for(int i=1;i<=col;i++){
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.print("\n");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+" \t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t"+rs.getString(8)+"\t\t"+rs.getString(9)+"\t\t"+rs.getString(10)+"\t\t"+rs.getString(11)+"\t\t"+rs.getString(12)+"\t"+rs.getString(13)+"\t"+rs.getString(14));  
			con.close();  
		} catch(Exception e){ System.out.println(e);}  
	}
	
	public static void Insert(String stmnt) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			Statement stmt=con.createStatement();  
		    stmt.executeUpdate(stmnt);
			con.close();  
		  }catch(Exception e){ System.out.println(e);}  
	}
	
	public static void Internal(String code,int roll) {
		String type="null";
		float num1=0,num2=0,sum=0;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			Statement stmt=con.createStatement();  
		    ResultSet rs = stmt.executeQuery("select * from subject where Code = '"+code+"'");
		    while(rs.next()){
		    	type=rs.getString("Type");
		    }
		    ResultSet res = stmt.executeQuery("select * from marks where Subject_code = '"+code+"' and Roll_No='"+roll+"'");
		    
		    while(res.next()) {
		    	num1=res.getFloat("Assessment1");
		    	num2=res.getFloat("Assessment2");
		    }
		    	if(type.equalsIgnoreCase("T")) {
			    	sum = ((num1/100)*20)+((num2/100)*20);	
			    	stmt.executeUpdate("UPDATE marks set TotalInternal= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	}
		    	else if(type.equalsIgnoreCase("LT")) {
			    	sum = ((num1/100)*25)+((num2/100)*25);	
			    	stmt.executeUpdate("UPDATE marks set TotalInternal= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	}
		    	else if(type.equalsIgnoreCase("L")) {
			    	sum = ((num1/100)*30)+((num2/100)*30);	
			    	stmt.executeUpdate("UPDATE marks set TotalInternal= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	}
		    
		     con.close();  
		  }catch(Exception e){ System.out.println(e);}  
	}
	
	public static void TotalAtt(String code,int tat,int roll) {
		int num1=0,num2=0,sum=0;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			Statement stmt=con.createStatement();  
		    ResultSet res = stmt.executeQuery("select * from marks where Subject_code = '"+code+"' and Roll_No='"+roll+"'");
		    
		    while(res.next()) {
		    	num1=res.getInt("Attendence1");
		    	num2=res.getInt("Attendence2");
		    }
		    sum = ((num1+num2)*100)/tat;
		    stmt.executeUpdate("UPDATE marks set TotalAttendence= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	
		    
		     con.close();  
		  }catch(Exception e){ System.out.println(e);}  
	}
	
	public static void total(String code,int roll) {
		String type="null";
		float num1=0,num2=0,sum=0,att=0;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			Statement stmt=con.createStatement();  
		    ResultSet rs = stmt.executeQuery("select * from subject where Code = '"+code+"'");
		    while(rs.next()){
		    	type=rs.getString("Type");
		    }
		    ResultSet res = stmt.executeQuery("select * from marks where Subject_code = '"+code+"' and Roll_No='"+roll+"'");
		    
		    while(res.next()) {
		    	num1=res.getFloat("TotalInternal");
		    	num2=res.getFloat("EndSem");
		    	att=res.getInt("TotalAttendence");
		    }
		    if(att<75) {
		    	stmt.executeUpdate("UPDATE marks set Total= '0' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    	stmt.executeUpdate("UPDATE marks set Grade = 'SA' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");

		    }
		    else if(num2>=0&&num2<45) {
		    	stmt.executeUpdate("UPDATE marks set Total= '0' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    	stmt.executeUpdate("UPDATE marks set Grade = 'RA' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");

		    }
		    
		    else {
		    	if(type.equalsIgnoreCase("T")) {
			    	sum = num1+((num2/100)*60);	
			    	stmt.executeUpdate("UPDATE marks set Total= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	}
		    	else if(type.equalsIgnoreCase("LT")) {
			    	sum = num1+((num2/100)*50);	
			    	stmt.executeUpdate("UPDATE marks set Total= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	}
		    	else if(type.equalsIgnoreCase("L")) {
			    	sum = num1+((num2/100)*40);	
			    	stmt.executeUpdate("UPDATE marks set Total= '"+ sum +"' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
			    	}
		    if(sum<50)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'RA' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else if(sum>=50&&sum<=55)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'C' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else if(sum>=56&&sum<=60)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'B' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else if(sum>=61&&sum<=70)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'B+' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else if(sum>=71&&sum<=80)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'A' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else if(sum>=81&&sum<=90)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'A+' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else if(sum>=91&&sum<=100)
		    	stmt.executeUpdate("UPDATE marks set Grade = 'O' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    else
		    	System.out.print("Total is out of bound\nRecheck the values");
		    }
		     con.close();  
		  }catch(Exception e){ System.out.println(e);}  

	}
	
	public static int Check_att(String code,int roll) {
		float att=0;
		int flag=0;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentportal","root","");  
			Statement stmt=con.createStatement();  
		    ResultSet res = stmt.executeQuery("select * from marks where Subject_code = '"+code+"' and Roll_No='"+roll+"'");
		    
		    while(res.next()) {
		    	att=res.getInt("TotalAttendence");
		    }
		    if(att<75) {
		    	stmt.executeUpdate("UPDATE marks set Total= '0' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    	stmt.executeUpdate("UPDATE marks set Grade = 'SA' where Subject_code='"+ code +"' AND Roll_No= '"+roll+"'");
		    	flag=1;
		    }
		    
		     con.close();  
		  }catch(Exception e){ System.out.println(e);}  
		return flag;

	}
	public static int AlphaCheck(String str) {
		int fl=0;
				 for(int i=0; i < str.length(); i++) {
			         Boolean f = Character.isDigit(str.charAt(i));
			         if(f) {
			           fl=1 ;
			         } else {
			            fl=0;
			            break;
			         }
			         }
				 if(fl==1)
					 return 1;
				 else
					 return 0;
	}
public static void main(String args[]) {
		
		Scanner obj=new Scanner(System.in);
		int num=0;
	//	do {
		System.out.println("Are you a 1)Student or 2)Teacher \n Enter your option(1 or 2):");
		int a=1,b=1;
		int option = obj.nextInt();
		/*check=AlphaCheck(option);
		if(check==1) {
			int op = Integer.parseInt(option);*/
		if(option== 1) {
	
			System.out.println("Enter your Roll_No:");
			int Roll = obj.nextInt();
			num=validate(Roll);
			while(a == 1) {
				if(num !=0) {
				//int e1=0;
			//	do {
					System.out.println("1)View Details \n 2)View Result \n 3)Exit \n Enter your option (1 or 2 or 3):");
					int choice = obj.nextInt();
				//int check1=0;
				//check1=AlphaCheck(choi);
				//if(check1==1) {
				//	int choice=Integer.parseInt(choi);
				
switch (choice) {
				
				case 1:
					
					Detail(Roll);
					break;
				case 2:
					String stmnt1="select * from marks where Roll_No ="+Roll;
					View(stmnt1);
					break;
				case 3:
					System.out.println("Exit");
					a=2;
					break;
					
				default:
					System.out.println("Out of Bound");
					break;
				}
if(a==1) {
	System.out.println("Do you want to continue \n 1)Yes \n 2)No \n Enter your choice(1 or 2):");
	a = obj.nextInt();}
				}
		
			else {
				System.out.println("Do you want to continue \n 1)Yes \n 2)No \n Enter your choice(1 or 2):");
				a = obj.nextInt();
				if(a==1) {
					System.out.println("Enter your Roll_No:");
					 Roll = obj.nextInt();
					num=validate(Roll);}
			}
			}
		}
		/*	else {
					System.out.println("Numeric values only accepted");
					e1=1;
				}
	//		}while(e1==1);*/
			
	
		
		
		else if(option == 2) {
			int flag1=0,c=0;
			System.out.println("Enter your Subject_code:");
			String code = obj.next();
			num=validate(code);
			while (b == 1) {
			  if(num != 0) {
			
				System.out.println("1)View Details \n 2)Enter marks \n 3)Enter Attendence \n 4)Update marks \n 5)Update Attendence \n 6)EndSem_Marks \n 7)Exit \n Enter your option(only numeric values):");
				int choice = obj.nextInt();
				

switch (choice) {
				
				case 1:
					String stmnt3="select * FROM marks where Subject_code='"+code+"'";
					View(stmnt3);
					break;
				case 2:
					System.out.println("1)Assess 1 \n 2)Assess 2 \n 3)Assess 3 \n 4)Exit \n Enter your option (only numeric values):");
					int ch1 = obj.nextInt();
					

switch (ch1) {
					
					case 1:
						flag1=CheckLock(code,"Asses1");
						if(flag1!=1) {
						for(int r=2001;r<=2005;r++) {
							System.out.println("Roll_NO:"+r+"\n Asses1 mark:");
							int mark=obj.nextInt();
							if(mark>=0&&mark<=100) {
								String stmnt4 = "UPDATE marks set Assessment1="+ mark +" where Subject_code='"+ code +"' AND Roll_No="+r;
								Insert(stmnt4);}
								else {
									System.out.println("Exceeds mark bound");
									r=r-1;
								}}
						System.out.println("Do you want to LOCK Asses1 marks:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Asses1 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}
						for(int r=2001;r<=2005;r++) {
							Internal(code,r);
						}}
						break;
					case 2:
						flag1=CheckLock(code,"Asses2");
						if(flag1!=1) {
						for(int r=2001;r<=2005;r++) {
							System.out.println("Roll_NO:"+r+"\n Asses2 mark:");
							int mark=obj.nextInt();
							if(mark>=0&&mark<=100) {

							String stmnt5 = "UPDATE marks set Assessment2="+ mark +" where Subject_code='"+ code +"' AND Roll_No="+r;
							Insert(stmnt5);}
							
						
						else {
							System.out.println("Exceeds mark bound");
							r=r-1;
						}}
						System.out.println("Do you want to LOCK Asses2 marks:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Asses2 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}
						
						for(int r=2001;r<=2005;r++) {
							Internal(code,r);
						}}
							break;
					case 3:
						System.out.println("Assess3 is not applicable");
						/*for(int r=2001;r<=2005;r++) {
							System.out.println("Roll_NO:"+r+"\n Asses3 mark:");
							int mark=obj.nextInt();
							String stmnt6 = "UPDATE marks set Assessment3="+ mark +" where Subject_code='"+ code +"' AND Roll_No="+r;
							Insert(stmnt6);}
							break;*/
							
					case 4:
						System.out.println("Exit");
						break;
						
					default:
						System.out.println("Out of Bound");
						break;
					}
					break;
						
				case 3:

					System.out.println("1)Assess 1 \n 2)Assess 2 \n 3)Assess 3 \n 4)Exit \n Enter your option (only numeric values):");
					int ch2 = obj.nextInt();
					int tat1=0,tat2=0,tat=0;
					
					switch (ch2) {
					
					case 1:
						flag1=CheckLock(code,"Att1");
						if(flag1!=1) {
						System.out.println("Total No of Session(Assess1):");
						 tat1=obj.nextInt();

						for(int r=2001;r<=2005;r++) {
							System.out.println("Roll_NO:"+r+"\n Asses1 Attendence:");
							int att=obj.nextInt();
							if(att>tat1) {
								System.out.println("Exceeds total number of sessions");
								r=r-1;}
							else
							{	
							String stmnt7 = "UPDATE marks set Attendence1="+ att +" where Subject_code='"+ code +"' AND Roll_No="+r;
							Insert(stmnt7);}}
						tat=tat1+tat2;
						for(int r=2001;r<=2005;r++) {
						    TotalAtt(code,tat,r);}
						System.out.println("Do you want to LOCK Att1 marks:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Att1 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}}
							break;
					case 2:
						int flag2=CheckLock(code,"Att2");
						if(flag2!=1) {

						System.out.println("Total No of Session(Assess2):");
					     tat2=obj.nextInt();

						for(int r=2001;r<=2005;r++) {
							System.out.println("Roll_NO:"+r+"\n Asses2 Attendence:");
							int att=obj.nextInt();
							if(att>tat2) {
								System.out.println("Exceeds total number of sessions");
								r=r-1;}
							else
							{
							String stmnt7 = "UPDATE marks set Attendence2="+ att +" where Subject_code='"+ code +"' AND Roll_No="+r;
							Insert(stmnt7);}
						}
						tat=tat1+tat2;
						for(int r=2001;r<=2005;r++) {
						    TotalAtt(code,tat,r);}
						System.out.println("Do you want to LOCK Att2 :\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Att2 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}}
							break;
					case 3:
						System.out.println("Assess3 is not applicable");

						/*for(int r=2001;r<=2005;r++) {
							System.out.println("Roll_NO:"+r+"\n Att.3 :");
							int att=obj.nextInt();
							String stmnt8 = "UPDATE marks set Attendence3="+ att +" where Subject_code='"+ code +"' AND Roll_No="+r;
							Insert(stmnt8);}
							break;*/
							
					case 4:
						System.out.println("Exit");
						break;
						
					default:
						System.out.println("Out of Bound");
						break;
					}
					break;
				
			 case 4:
				System.out.println("1)Assess 1 \n 2)Assess 2 \n 3)Assess 3 \n 4)Exit \n Enter your option (only numeric values):");
				int ch3 = obj.nextInt();
				if(ch3==1) {
					int flag6=CheckLock(code,"Asses1");
					if(flag6!=1) {
						System.out.println("Enter Student Roll_No:");
						int rno=obj.nextInt();
						int n =validate(rno);
						if(n!=0) {
							System.out.println("Enter Updated Mark:");
							int m = obj.nextInt();
							if(m>=0&&m<=100) {

								String stmnt9 = "UPDATE marks set Assessment"+ch3+"="+ m +" where Subject_code='"+ code +"' AND Roll_No="+rno;
								Insert(stmnt9);
								Internal(code,rno);
						System.out.println("Do you want to LOCK Asses1:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Asses1 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}}
							else {
								System.out.println("Exceeds mark bound");
							}}
					}}
				else if(ch3==2) {
					int flag7=CheckLock(code,"Asses2");
					if(flag7!=1) {
						System.out.println("Enter Student Roll_No:");
						int rno=obj.nextInt();
						int n =validate(rno);
						if(n!=0) {
						System.out.println("Enter Updated Mark:");
						int m = obj.nextInt();
						if(m>=0&&m<=100) {

						String stmnt9 = "UPDATE marks set Assessment"+ch3+"="+ m +" where Subject_code='"+ code +"' AND Roll_No="+rno;
						Insert(stmnt9);
						Internal(code,rno);
						System.out.println("Do you want to LOCK Asses2 marks:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Asses2 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}}
						else {
							System.out.println("Exceeds mark bound");
						}}
					}
				}
				else if(ch3==3) {
					System.out.println("Assess3 is not applicable");

				}
				else
					System.out.println("your choice is out of bound");

				
				break;
			 case 5:
				System.out.println("1)Assess 1 \n 2)Assess 2 \n 3)Assess 3 \n 4)Exit \n Enter your option (only numeric values):");
				int ch4 = obj.nextInt();
				if (ch4==1) {
					int flag8=CheckLock(code,"Att1");
					if(flag8!=1) {
						System.out.println("Enter Student Roll_No:");
						int rn=obj.nextInt();
						int n1 =validate(rn);
						if(n1!=0) {
							System.out.println("Total No of Session(Assess1+Assess2):");
						    int tatn=obj.nextInt();
						    System.out.println("Enter Updated Attendence:");
						int at = obj.nextInt();
						String stmnt10 = "UPDATE marks set Attendence"+ch4+"="+ at +" where Subject_code='"+ code +"' AND Roll_No="+rn;
						Insert(stmnt10);
						    TotalAtt(code,tatn,rn);}
						System.out.println("Do you want to LOCK Att1 marks:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Att1 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}
						for(int r=2001;r<=2005;r++) {
							Internal(code,r);
						}}}
					else if(ch4==2) {
						int flag9=CheckLock(code,"Att2");
						if(flag9!=1) {
							System.out.println("Enter Student Roll_No:");
							int rn=obj.nextInt();
							int n1 =validate(rn);
							if(n1!=0) {
							System.out.println("Total No of Session(Assess1+Assess2):");
						    int tatn=obj.nextInt();
						    System.out.println("Enter Updated Attendence:");
							int at = obj.nextInt();
							String stmnt10 = "UPDATE marks set Attendence"+ch4+"="+ at +" where Subject_code='"+ code +"' AND Roll_No="+rn;
							Insert(stmnt10);
							    TotalAtt(code,tatn,rn);}
						System.out.println("Do you want to LOCK Att2 marks:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Att2 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}
						for(int r=2001;r<=2005;r++) {
							Internal(code,r);
						}}
						
					}
					else if(ch4==3) {
						System.out.println("Assess3 is not applicable");

					}
					else
						System.out.println("Your choice is out of bound");

				
				break;
				
			 case 6:
				 int flag;
				 int flag0=0;
				 int f[]=new int[5];
					f[1]=CheckLock(code,"Asses1");
					f[2]=CheckLock(code,"Asses2");
					f[3]=CheckLock(code,"Att1");
					f[4]=CheckLock(code,"Att2");
				for(int i=1;i<=4;i++) {
					if(f[i]==0) {
						if(i==1)
							System.out.println("Asses1 is not yet LOCKED");
						else if(i==2)
							System.out.println("Asses2 is not yet LOCKED");
						else if(i==3)
							System.out.println("Att1 is not yet LOCKED");
						else if(i==4)
							System.out.println("Att2 is not yet LOCKED");
						flag0=1;
					}
						
				}
				if(flag0!=1) {
					 for(int r=2001;r<=2005;r++) {
						 flag=Check_att(code,r);
						 if(flag==1) {
							System.out.println("Roll_NO:"+r+"\n SA");
							String stmnt0 = "UPDATE marks set EndSem = '0' where Subject_code='"+ code +"' AND Roll_No="+r;
							Insert(stmnt0);}
					   else {
							System.out.println("Roll_NO:"+r+"\n EndSem Mark:");
						int att=obj.nextInt();
						String stmnt7 = "UPDATE marks set EndSem ="+ att +" where Subject_code='"+ code +"' AND Roll_No="+r;
						Insert(stmnt7);}}
					 for(int r=2001;r<=2005;r++) {
						 total(code,r);}
					 System.out.println("Do you want to LOCK Att1:\n1)YES\n2)NO\nEnter your choice(1 or 2):");
						c=obj.nextInt();
						if(c==1) {
							String stmnt11 = "UPDATE locktable set Att1 = 1 where Subject_code='"+ code +"'";
							Insert(stmnt11);
						}
				 
				}
				break;
			 case 7:
				 System.out.println("Exit");
					b=2;
					break;
			 default:
				 System.out.println("Out of Bound");
					break;
				
			}
if(b==1) {
				System.out.println("Do you want to continue \n 1)Yes \n 2)No \n Enter your choice(1 or 2):");
				b = obj.nextInt();}
		  }
			  else {
					System.out.println("Do you want to continue \n 1)Yes \n 2)No \n Enter your choice(1 or 2):");
					b = obj.nextInt();
					if(b==1) {
						System.out.println("Enter your Subject_Code:");
						  code = obj.next();
						num=validate(code);}
				}
			}}
	   
		else {
			System.out.println("choose option within 1 or 2");
			
		}
		
		//else {
			//System.out.println("Numeric values only accepted");
			//e=1;
		//}while(e==1);
		obj.close();
	}
}
