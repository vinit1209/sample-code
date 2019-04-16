<?php

// Update the path below to your autoload.php,
// see https://getcomposer.org/doc/01-basic-usage.md
require_once '/path/to/vendor/autoload.php';

use Twilio\Rest\Client;

// Find your Account Sid and Auth Token at twilio.com/console
// DANGER! This is insecure. See http://twil.io/secure
$sid    = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
$token  = "your_auth_token";
$twilio = new Client($sid, $token);

$notification = $twilio->notify->v1->services("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
                                   ->notifications
                                   ->create(array(
                                                "apn" => array(
                                                    "aps" => array(
                                                        "alert" => array(
                                                            "title" => "Bob alert",
                                                            "body" => "Bob, you just received a badge"
                                                        ),
                                                        "badge" => 1
                                                    )
                                                ),
                                                "identity" => "00000001"
                                            )
                                   );

print($notification->sid);