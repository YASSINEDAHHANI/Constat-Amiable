const {onRequest} = require("firebase-functions/v2/https");
const sgMail = require("@sendgrid/mail");

sgMail.setApiKey("8b4f93f829d417f1daff4eef19fd819c-826eddfb-260fe2d6");

exports.sendEmail = onRequest((request, response) => {
  const emailData = request.body;

  const msg = {
    to: "dahyassine7@@gmail.com", // Admin email address
    from: "sanlam@gmail.com", // Your verified sender email
    subject: "New Constats Submitted",
    text: `Details:\n${JSON.stringify(emailData)}`,
    html: `<p>Details:</p><pre>${JSON.stringify(emailData)}</pre>`,
  };

  sgMail.send(msg)
      .then(() => {
        response.status(200).send("Email sent successfully");
      })
      .catch((error) => {
        response.status(500).send(`Error sending email: ${error.message}`);
      });
});
