# Payment-App-using-Razorpay
<p align="center">
  <img src="https://github.com/Suvam-Dawn/Razorpay-For-Android/blob/master/README/razorpay.png"width="15%;" height="100px;"/><br/>
   <b>Razorpay-For-Android</h1><br/>Razorpay (Payment Gateway- https://razorpay.com/) Integration in Android</b>
</p>
<h6>Razorpay is a payments company that provides payment solutions to online merchants in India. Razorpay was founded in 2014 and is headquartered in Bangalore, India. Razorpay allows online businesses to accept, process and disburse digital payments through several payment modes like debit cards, credit cards, net banking, UPI and prepaid digital wallets. Razorpay payment solutions can be integrated by both web and mobile applications.</h6>
<hr>

<p><b> Steps:- </b></p>
<ol type="1">
  <li>Create your account into Razorpay (https://razorpay.com/) .</li>
  <li>Generate Razorpay Key Id from Settings-> API Keys and copy Key Id.</li>
  <img src="https://github.com/Suvam-Dawn/Razorpay-For-Android/blob/master/README/Razorpay%20Key%20Id.png"/>
  <li>Add <b> implementation 'com.razorpay:checkout:1.6.22' </b> into app lable gradle file's <b>dependencies.</b></li>
  <li>Check <b>minSdkVersion</b>, Razorpay works from <b>SDK - 19 .</b></li>
  <li>Add Internet permission into AndroidManifest.xml file<br><b> &#60;uses-permission android:name="android.permission.INTERNET"/&#62; </b> </br></li>
  <li>Check main code from <a href="https://github.com/Prateek-Nayak/Payment-App-using-Razorpay/tree/main/app/src/main/java/com/example/razorpay/MainActivity.java" target="_blank">MainActivity.java</a></li>
</ol>
