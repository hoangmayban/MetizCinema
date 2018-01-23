#Author: hoangvo@vooc.vn	
#Keywords Summary : Login to Metiz website


Feature: Login successfully
 
  
  Scenario Outline: User login to Metiz website
   Given user is on Home Page
	 When he click on Dang Nhap button
	 And enter email and password of valid "<account>" at Login Page
	 And click on DangNhap button at Login Page
	 Then login successfully and username is displayed
Examples:
		|account|
		|V2HOANG@gmail.com|	 



