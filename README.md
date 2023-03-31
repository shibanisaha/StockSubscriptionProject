Spring boot stock detail subscription project.
Databased used mongoDB atlas.
 
User can register and login with email & password. Authentication of User is implemented with spring security DaoAuthentication and JWT authentication.

Polygon API is used to get stock data based on stock ticker, start and end date.

User can subscribe to different company stock ticker and notification frequency as Daily, Weekly, Biweekly or Monthly at particular UTC time to receive mail.
Spring scheduler and spring mail service is used to send subscription email.
Every one minute my scheduler checks if any subscription is present in DB where schedule time was before, if yes then it calls the JavaMailSender to send email and update the schedule time for next date based on notification frequency.