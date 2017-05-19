**GETUSER**
----

* **URL**

  /api/getuser/{userId}

* **Method:**
  
  `GET`
  
*  **URL Params**

   **Required:**
 
   `Integer userId`

   **Optional:**
 
   `none`

* **Data Params**

  `none`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                    "userId": 1,
                    "email": "jimseinta@gmail.com"
                  }`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `{
                    "timestamp": 1495193918161,
                    "status": 400,
                    "error": "Bad Request",
                    "exception": "com.webapplication.exceptions.BadRequestException",
                    "message": "User not found",
                    "path": "/api/getuser/{userId}"
                  }`

  OR

  `something else`
