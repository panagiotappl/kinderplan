**GETUSER**
----

* **URL**

  /api/user/{userId}

* **Method:**
  
  `GET`
  
*  **URL Params**

   **Required:**
 
   `{userId}`

   **Optional:**
 
   `none`

* **Data Params**

  `none`

* **Headers**

    `Content-Type: application/json`
  
    `authToken: ec688df7-8814-49f6-adb3-ecd52620325d`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                    "id": 1,
                    "name": "Jack",
                    "surname": "Bauer",
                    "email": "a@a.com",
                    "validated": true,
                    "createdDate": null,
                    "updatedDate": null,
                    "lastLogin": null
                  }`
 
* **Error Response:**

  * **Code:** 403 Forbidden
    **Content:** `{
                    "timestamp": 1495965135222,
                    "status": 403,
                    "error": "Forbidden",
                    "exception": "com.webapplication.exception.NotAuthorizedException",
                    "message": "Unauthorized user.",
                    "path": "/api/user/18"
                  }`
                  
 
  * **Code:** 500 Internal Server Error
    **Content:** `{
                    "timestamp": 1495965196318,
                    "status": 500,
                    "error": "Internal Server Error",
                    "exception": "org.springframework.web.bind.ServletRequestBindingException",
                    "message": "Missing request header 'authToken' for method parameter of type UUID",
                    "path": "/api/user/1"
                  }`

 
