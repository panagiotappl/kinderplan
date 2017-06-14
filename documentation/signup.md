**SIGNUP**
----

* **URL**

  /api/signup

* **Method:**

  `POST`

*  **URL Params**

   **Required:**

   `none`

   **Optional:**

   `none`

* **Data Params for parent**

  `{
"address":"Arizona, Fili, Ditiki Attiki, Greece",
"name":"dimitris",
"surname":"seintaridis",
"latitude":"38.0984785",
"longitude":"23.67137219999995",
"email":"jimseinta@gmail.com",
"password":"seinta",
"phone":"+123456789",
"repassword":"seinta",
"role":"parent",
"parent":{
	       "points":"20"
        }
}`

* **Data Params for provider**

  `{
"address":"Arizona, Fili, Ditiki Attiki, Greece",
"name":"dimitris",
"surname":"seintaridis",
"latitude":"38.0984785",
"longitude":"23.67137219999995",
"email":"jimseinta@hotmail.com",
"password":"seinta",
"phone":"+123456789",
"repassword":"seinta",
"role":"provider",
"provider":{
	       "vatnumber":"20",
	       "companyname":"facebook"
        }
}`

* **Headers**

    `Content-Type: application/json`


* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                    "status": "OK",
                    "message": "User is registered succesfully"
                  }`

* **Error Response:**

  * **Code:** 400 Bad Request

    **Content:** `{
                    "timestamp": 1496104838948,
                    "status": 400,
                    "error": "Bad Request",
                    "exception": "com.webapplication.exception.ValidationException",
                    "message": "Role is missing.",
                    "path": "/api/signup"
                    }`

  
