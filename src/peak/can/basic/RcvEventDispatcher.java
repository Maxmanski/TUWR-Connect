package peak.can.basic;

/**
 * This class is a gateway between the PCAN Light JNI and the application to dispatch the CAN Receive-Event.
 *
 * RcvEventDispatcher contains a public static method dispatchRcvEvent which is called from the JNI to notify the Java
 * application when the handle of the Receive-Event detects a state change.
 * 
 * @version 1.8
 * @LastChange 11/03/2013
 * @author Jonathan Urban/Uwe Wilhelm
 *
 * @Copyright (C) 1999-2013  PEAK-System Technik GmbH, Darmstadt
 * more Info at http://www.peak-system.com
*/
public class RcvEventDispatcher
{
    static private IRcvEventProcessor listener;

    /**
     * Gets the Receive-Event processor
     * @return a IRcvEventProcessor
     */
    public static IRcvEventProcessor getListener()
    {
        return listener;
    }

    /**
     * Sets the Receive-Event processor
     * @param listener a IRcvEventProcessor implementor
     */
    public static void setListener(IRcvEventProcessor listener)
    {
        RcvEventDispatcher.listener = listener;
    }

    /**
     * This static public method will call from JNI to process the Receive-Event
     * by the listener
     */
    static public void dispatchRcvEvent(TPCANHandle channel)
    {
        if(listener != null)
            listener.processRcvEvent(channel);
    }
}
