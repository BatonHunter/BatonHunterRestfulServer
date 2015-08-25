# BatonHunterRestfulServer
Restful server for Baton Hunter

##Category
###Get:   /categories
Get all categories
###Get:   /categories/:title/subcategory
###Get:   /categories/:title/subcategory/:title/job
*e.g: /categories/經營管理/subcategory/金融投資/job

##Job
###Get    /jobs/:jobId
###Get    /jobs/:jobId/question
###Get    /jobs/:jobId/task
###Get    /jobs/:jobId/task/:taskId
###Get:   /jobs/:jobId/task/:taskId/question

##Treasure
###Post   /treasures
{"email" : "baton@baton.com",
"treasure" : "slot"}
type can also be big, little, and boss

##User
###Post     /users
{"email":"baton@baton.com",
"picUri":"www.google.com",
"name":"batonhunter"
}
###Get     /users/:email
###Post    /users/:email/strength
###Post    /users/:email/job
{"id":"9",
"title":"攻城屍"
}
###Post   /users/:email/card
{"title":"JIRO!"}
###Put    /users/:email/job/:jobId/task/:taskId
###Delete    /users/:email/job/:jobId

##Email
###Post    /emails
{"content" : "I am jiro, I am the best man ever",
"to" : "jiro@bestman.com",
"subject" : "best man here"
    }
