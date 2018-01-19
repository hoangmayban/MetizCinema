#Author: hoangvo@vooc.vn	
#Keywords Summary : Login to Metiz website


Feature: Login successfully
 
  
  Scenario: User login to Metiz website
   Given user is on Home Page
	 When he click on Dang Nhap button
	 And enter email and password at Login Page
	 And click on DangNhap button at Login Page
	 Then login successfully and username is displayed
	 



