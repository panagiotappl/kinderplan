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

  `{"email": "a@a.com", "password": "123"}`
  
* **Headers**

    `Content-Type: application/json`
  

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                    "userId": 1,
                    "authToken": "9635442a-9af5-4424-b107-b0249d8c758a",
                    "role": "Parents"
                  }`
 
* **Error Response:**

  * **Code:** 401 Unauthorized
 
    **Content:** `{
                    "timestamp": 1495964805997,
                    "status": 401,
                    "error": "Unauthorized",
                    "exception": "com.webapplication.exception.user.NotAuthenticatedException",
                    "message": "Username and password do not match.",
                    "path": "/api/login"
                  }`
                  
  * **Code:** 400 Bad Request
   
      **Content:** `{
                      "timestamp": 1495964877050,
                      "status": 400,
                      "error": "Bad Request",
                      "exception": "com.webapplication.exception.ValidationException",
                      "message": "Invalid data." or "Email or password missing",
                      "path": "/api/login"
                    }`


