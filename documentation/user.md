**GETUSER**
----

* **URL**

  /api/user

* **Method:**
  
  `GET`
  
*  **URL Params**

   **Required:**
 
   `none`

   **Optional:**
 
   `none`

* **Data Params**

  `none`

* **Headers**

    `Content-Type: application/json`
  
    `Authorization: Basic YUBhLmdyOjMyMQ==`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                    "id": 2,
                    "name": "Chloe",
                    "surname": "O'Brian",
                    "email": "a@a.gr",
                    "validated": true,
                    "createdDate": null,
                    "updatedDate": null,
                    "lastLogin": null,
                    "role": "Provider"
                  }`
 
* **Error Response:**

  * **Code:** 500 Internal Server Error <br />
    **Content:** `HTTP Status 500 - null`

 
