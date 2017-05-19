**LOGIN**
----

* **URL**

  /api/login

* **Method:**
  
  `POST`
  
*  **URL Params**

   **Required:**
 
   `none`

   **Optional:**
 
   `none`

* **Data Params**

  `{ email: "email", 
     password: "password" }`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ userId: 1, role: "2", generatedToken: "token" }`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `{
                    "timestamp": 1495193918161,
                    "status": 400,
                    "error": "Bad Request",
                    "exception": "com.webapplication.exceptions.BadRequestException",
                    "message": "User not found",
                    "path": "/api/login"
                  }`

  OR

  `something else`
