# BatonHunterRestfulServer
Restful server for Baton Hunter

##Category
###Get:   /categories
Get all categories
###Get:   /categories/:title/job
Get all job in specific category by provide title
*e.g: /categories/經營管理/job

##Job
###Get    /jobs/:jobId
###Get    /jobs/:jobId/task
###Get    /jobs/:jobId/task/:taskId
###Get:   /jobs/:jobId/task/:taskId/question

##Treasure
###Post   /treasures
{"email" : "baton@baton.com",
"type" : "slot"}

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
###Put    /users/:email/job/:jobId/task/:taskId
###Delete    /users/:email/job/:jobId
