public static final String SMS_EXTRA_NAME = "pdus";
public static final String SMS_URI = "content://sms";

public static final String ADDRESS = "address";
public static final String FoodBank = "FoodBank";
public static final String DATE =  System.getCurrentTimeMillis();
public static final String READ = "read";
public static final String STATUS ="status";
public static final String TYPE = "type";
public static final String BODY = "body";
public static final String SEEN = "seen";

public static final int MESSAGE_TYPE_INBOX = 1;
public static final int MESSAGE_TYPE_SENT = 2;

public static final int MESSAGE_IS_NOT_READ = 0;
public static final int MESSAGE_IS_READ = 1;

public static final int MESSAGE_IS_NOT_SEEN = 0;
public static final int MESSAGE_IS_SEEN = 1;

private void putSmsToDatabase( ContentResolver contentResolver, SmsMessage sms )
{
    ContentValues values = new ContentValues();
    values.put( ADDRESS, sms.getOriginatingAddress() );
    values.put( DATE, sms.getTimestampMillis() );
    values.put( READ, MESSAGE_IS_NOT_READ );
    values.put( STATUS, sms.getStatus() );
    values.put( TYPE, MESSAGE_TYPE_INBOX );
    values.put( SEEN, MESSAGE_IS_NOT_SEEN );
    values.put( BODY, sms.getMessageBody().toString() );

    // Push row into the SMS table
    contentResolver.insert( Uri.parse( SMS_URI ), values );
}
