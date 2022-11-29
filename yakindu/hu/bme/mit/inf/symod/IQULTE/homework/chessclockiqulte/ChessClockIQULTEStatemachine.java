package hu.bme.mit.inf.symod.IQULTE.homework.chessclockiqulte;
import hu.bme.mit.inf.symod.IQULTE.homework.ITimer;

public class ChessClockIQULTEStatemachine implements IChessClockIQULTEStatemachine {

	protected class SCIButtonsImpl implements SCIButtons {
	
		private boolean modeButton;
		
		public void raiseModeButton() {
			modeButton = true;
		}
		
		private boolean startButton;
		
		public void raiseStartButton() {
			startButton = true;
		}
		
		private boolean blackButton;
		
		public void raiseBlackButton() {
			blackButton = true;
		}
		
		private boolean whiteButton;
		
		public void raiseWhiteButton() {
			whiteButton = true;
		}
		
		protected void clearEvents() {
			modeButton = false;
			startButton = false;
			blackButton = false;
			whiteButton = false;
		}
	}
	
	protected SCIButtonsImpl sCIButtons;
	
	protected class SCIBeeperImpl implements SCIBeeper {
	
		private SCIBeeperOperationCallback operationCallback;
		
		public void setSCIBeeperOperationCallback(
				SCIBeeperOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCIBeeperImpl sCIBeeper;
	
	protected class SCIDisplayImpl implements SCIDisplay {
	
		private String text;
		
		public String getText() {
			return text;
		}
		
		public void setText(String value) {
			this.text = value;
		}
		
		private long whiteDisplay;
		
		public long getWhiteDisplay() {
			return whiteDisplay;
		}
		
		public void setWhiteDisplay(long value) {
			this.whiteDisplay = value;
		}
		
		private long blackDisplay;
		
		public long getBlackDisplay() {
			return blackDisplay;
		}
		
		public void setBlackDisplay(long value) {
			this.blackDisplay = value;
		}
		
	}
	
	protected SCIDisplayImpl sCIDisplay;
	
	private boolean initialized = false;
	
	public enum State {
		__White_begins,
		__Initial_time,
		__Increment_Time,
		__Maximal_time,
		__Ready_to_play__2_,
		__White_moves,
		__Ready_to_play__1_,
		__Black_moves,
		__White_lost,
		__Black_lost,
		__Game_Over,
		__Black_begins,
		__Initial_time__2_,
		__Increment_Time__2_,
		__Maximal_time__2_,
		__Ready_to_play__3_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
	
	
	private long increment;
	
	protected void setIncrement(long value) {
		increment = value;
	}
	
	protected long getIncrement() {
		return increment;
	}
	
	private long maximalTime;
	
	protected void setMaximalTime(long value) {
		maximalTime = value;
	}
	
	protected long getMaximalTime() {
		return maximalTime;
	}
	
	private long whiteInit;
	
	protected void setWhiteInit(long value) {
		whiteInit = value;
	}
	
	protected long getWhiteInit() {
		return whiteInit;
	}
	
	private long blackInit;
	
	protected void setBlackInit(long value) {
		blackInit = value;
	}
	
	protected long getBlackInit() {
		return blackInit;
	}
	
	private long whiteIncrement;
	
	protected void setWhiteIncrement(long value) {
		whiteIncrement = value;
	}
	
	protected long getWhiteIncrement() {
		return whiteIncrement;
	}
	
	private long blackIncrement;
	
	protected void setBlackIncrement(long value) {
		blackIncrement = value;
	}
	
	protected long getBlackIncrement() {
		return blackIncrement;
	}
	
	private long whiteDisplay2;
	
	protected void setWhiteDisplay2(long value) {
		whiteDisplay2 = value;
	}
	
	protected long getWhiteDisplay2() {
		return whiteDisplay2;
	}
	
	private long incrementBlack;
	
	protected void setIncrementBlack(long value) {
		incrementBlack = value;
	}
	
	protected long getIncrementBlack() {
		return incrementBlack;
	}
	
	private long maximalTimeBlack;
	
	protected void setMaximalTimeBlack(long value) {
		maximalTimeBlack = value;
	}
	
	protected long getMaximalTimeBlack() {
		return maximalTimeBlack;
	}
	
	private long whiteInitBlack;
	
	protected void setWhiteInitBlack(long value) {
		whiteInitBlack = value;
	}
	
	protected long getWhiteInitBlack() {
		return whiteInitBlack;
	}
	
	private long blackInitBlack;
	
	protected void setBlackInitBlack(long value) {
		blackInitBlack = value;
	}
	
	protected long getBlackInitBlack() {
		return blackInitBlack;
	}
	
	private long whiteIncrementBlack;
	
	protected void setWhiteIncrementBlack(long value) {
		whiteIncrementBlack = value;
	}
	
	protected long getWhiteIncrementBlack() {
		return whiteIncrementBlack;
	}
	
	private long blackIncrementBlack;
	
	protected void setBlackIncrementBlack(long value) {
		blackIncrementBlack = value;
	}
	
	protected long getBlackIncrementBlack() {
		return blackIncrementBlack;
	}
	
	private long whiteCounter;
	
	protected void setWhiteCounter(long value) {
		whiteCounter = value;
	}
	
	protected long getWhiteCounter() {
		return whiteCounter;
	}
	
	private long blackCounter;
	
	protected void setBlackCounter(long value) {
		blackCounter = value;
	}
	
	protected long getBlackCounter() {
		return blackCounter;
	}
	
	public ChessClockIQULTEStatemachine() {
		sCIButtons = new SCIButtonsImpl();
		sCIBeeper = new SCIBeeperImpl();
		sCIDisplay = new SCIDisplayImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		
		if (this.sCIBeeper.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCIBeeper must be set.");
		}
		
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCIDisplay.setText("Chess Clock");
		
		sCIDisplay.setWhiteDisplay(-1);
		
		sCIDisplay.setBlackDisplay(-1);
		
		setIncrement(0);
		
		setMaximalTime(600);
		
		setWhiteInit(120);
		
		setBlackInit(120);
		
		setWhiteIncrement(0);
		
		setBlackIncrement(0);
		
		setWhiteDisplay2(0);
		
		setIncrementBlack(10);
		
		setMaximalTimeBlack(600);
		
		setWhiteInitBlack(120);
		
		setBlackInitBlack(120);
		
		setWhiteIncrementBlack(0);
		
		setBlackIncrementBlack(0);
		
		setWhiteCounter(0);
		
		setBlackCounter(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
	
		enterSequence___default();
	}
	
	public void exit() {
		exitSequence__();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCIButtons.clearEvents();
		for (int i=0; i<timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case __White_begins:
			return stateVector[0] == State.__White_begins;
		case __Initial_time:
			return stateVector[0] == State.__Initial_time;
		case __Increment_Time:
			return stateVector[0] == State.__Increment_Time;
		case __Maximal_time:
			return stateVector[0] == State.__Maximal_time;
		case __Ready_to_play__2_:
			return stateVector[0] == State.__Ready_to_play__2_;
		case __White_moves:
			return stateVector[0] == State.__White_moves;
		case __Ready_to_play__1_:
			return stateVector[0] == State.__Ready_to_play__1_;
		case __Black_moves:
			return stateVector[0] == State.__Black_moves;
		case __White_lost:
			return stateVector[0] == State.__White_lost;
		case __Black_lost:
			return stateVector[0] == State.__Black_lost;
		case __Game_Over:
			return stateVector[0] == State.__Game_Over;
		case __Black_begins:
			return stateVector[0] == State.__Black_begins;
		case __Initial_time__2_:
			return stateVector[0] == State.__Initial_time__2_;
		case __Increment_Time__2_:
			return stateVector[0] == State.__Increment_Time__2_;
		case __Maximal_time__2_:
			return stateVector[0] == State.__Maximal_time__2_;
		case __Ready_to_play__3_:
			return stateVector[0] == State.__Ready_to_play__3_;
		default:
			return false;
		}
	}
	
	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correct
	* executed.
	* 
	* @param timer
	*/
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}
	
	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return timer;
	}
	
	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}
	
	public SCIButtons getSCIButtons() {
		return sCIButtons;
	}
	
	public SCIBeeper getSCIBeeper() {
		return sCIBeeper;
	}
	
	public SCIDisplay getSCIDisplay() {
		return sCIDisplay;
	}
	
	private boolean check___White_begins_tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___White_begins_tr1_tr1() {
		return sCIButtons.blackButton;
	}
	
	private boolean check___Initial_time_tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Initial_time_tr1_tr1() {
		return (sCIButtons.whiteButton) && (getWhiteInit()<300 && getBlackInit()<300);
	}
	
	private boolean check___Initial_time_tr2_tr2() {
		return (sCIButtons.blackButton) && (getWhiteInit()>30 && getBlackInit()>30);
	}
	
	private boolean check___Initial_time_tr3_tr3() {
		return sCIButtons.startButton;
	}
	
	private boolean check___Initial_time_tr4_tr4() {
		return sCIButtons.whiteButton || sCIButtons.blackButton;
	}
	
	private boolean check___Increment_Time_tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Increment_Time_tr1_tr1() {
		return (sCIButtons.whiteButton) && (sCIDisplay.getWhiteDisplay()<30);
	}
	
	private boolean check___Increment_Time_tr2_tr2() {
		return (sCIButtons.blackButton) && (sCIDisplay.getWhiteDisplay()>0);
	}
	
	private boolean check___Increment_Time_tr3_tr3() {
		return (sCIButtons.blackButton) && (sCIDisplay.getWhiteDisplay()==0);
	}
	
	private boolean check___Increment_Time_tr4_tr4() {
		return (sCIButtons.whiteButton) && (sCIDisplay.getWhiteDisplay()==30);
	}
	
	private boolean check___Maximal_time_tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Maximal_time_tr1_tr1() {
		return (sCIButtons.whiteButton) && (getMaximalTime()<1200);
	}
	
	private boolean check___Maximal_time_tr2_tr2() {
		return (sCIButtons.blackButton) && (getMaximalTime()>600);
	}
	
	private boolean check___Maximal_time_tr3_tr3() {
		return (sCIButtons.blackButton) && (getMaximalTime()<=600 && getMaximalTime()<1200);
	}
	
	private boolean check___Maximal_time_tr4_tr4() {
		return sCIButtons.whiteButton;
	}
	
	private boolean check___Ready_to_play__2__tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Ready_to_play__2__tr1_tr1() {
		return sCIButtons.startButton;
	}
	
	private boolean check___White_moves_lr1_lr1() {
		return sCIDisplay.getWhiteDisplay()>600;
	}
	
	private boolean check___White_moves_lr2_lr2() {
		return sCIDisplay.getBlackDisplay()>600;
	}
	
	private boolean check___White_moves_tr0_tr0() {
		return sCIButtons.startButton;
	}
	
	private boolean check___White_moves_tr1_tr1() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___White_moves_tr2_tr2() {
		return sCIButtons.whiteButton;
	}
	
	private boolean check___White_moves_tr3_tr3() {
		return timeEvents[0];
	}
	
	private boolean check___Ready_to_play__1__tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Ready_to_play__1__tr1_tr1() {
		return sCIButtons.startButton;
	}
	
	private boolean check___Black_moves_lr1_lr1() {
		return sCIDisplay.getBlackDisplay()>600;
	}
	
	private boolean check___Black_moves_lr2_lr2() {
		return sCIDisplay.getWhiteDisplay()>600;
	}
	
	private boolean check___Black_moves_tr0_tr0() {
		return timeEvents[1];
	}
	
	private boolean check___Black_moves_tr1_tr1() {
		return sCIButtons.startButton;
	}
	
	private boolean check___Black_moves_tr2_tr2() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Black_moves_tr3_tr3() {
		return sCIButtons.blackButton;
	}
	
	private boolean check___White_lost_tr0_tr0() {
		return sCIButtons.startButton;
	}
	
	private boolean check___Black_lost_tr0_tr0() {
		return sCIButtons.startButton;
	}
	
	private boolean check___Game_Over_tr0_tr0() {
		return sCIButtons.startButton;
	}
	
	private boolean check___Black_begins_tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Black_begins_tr1_tr1() {
		return sCIButtons.whiteButton;
	}
	
	private boolean check___Black_begins_tr2_tr2() {
		return sCIButtons.blackButton;
	}
	
	private boolean check___Initial_time__2__tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Initial_time__2__tr1_tr1() {
		return (sCIButtons.whiteButton) && (sCIDisplay.getBlackDisplay()<300);
	}
	
	private boolean check___Initial_time__2__tr2_tr2() {
		return (sCIButtons.blackButton) && (sCIDisplay.getBlackDisplay()>30);
	}
	
	private boolean check___Initial_time__2__tr3_tr3() {
		return sCIButtons.whiteButton || sCIButtons.blackButton;
	}
	
	private boolean check___Increment_Time__2__tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Increment_Time__2__tr1_tr1() {
		return (sCIButtons.whiteButton) && (getIncrementBlack()>0 || getIncrementBlack()<30);
	}
	
	private boolean check___Increment_Time__2__tr2_tr2() {
		return (sCIButtons.blackButton) && (getIncrementBlack()>0 || getIncrementBlack()<30);
	}
	
	private boolean check___Maximal_time__2__tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Maximal_time__2__tr1_tr1() {
		return (sCIButtons.whiteButton) && (getMaximalTimeBlack()>600 || getMaximalTimeBlack()<1200);
	}
	
	private boolean check___Maximal_time__2__tr2_tr2() {
		return (sCIButtons.blackButton) && (getMaximalTimeBlack()>600 || getMaximalTimeBlack()<1200);
	}
	
	private boolean check___Ready_to_play__3__tr0_tr0() {
		return sCIButtons.modeButton;
	}
	
	private boolean check___Ready_to_play__3__tr1_tr1() {
		return sCIButtons.startButton;
	}
	
	private boolean check____choice_0_tr1_tr1() {
		return sCIDisplay.getWhiteDisplay()!=0;
	}
	
	private boolean check____choice_0_tr0_tr0() {
		return true;
	}
	
	private boolean check____choice_1_tr0_tr0() {
		return sCIDisplay.getWhiteDisplay()!=0;
	}
	
	private boolean check____choice_1_tr1_tr1() {
		return true;
	}
	
	private boolean check____choice_2_tr0_tr0() {
		return getMaximalTime()>600;
	}
	
	private boolean check____choice_2_tr1_tr1() {
		return getMaximalTime()>=1200;
	}
	
	private boolean check____choice_2_tr2_tr2() {
		return true;
	}
	
	private void effect___White_begins_tr0() {
		exitSequence___White_begins();
		enterSequence___Initial_time_default();
	}
	
	private void effect___White_begins_tr1() {
		exitSequence___White_begins();
		enterSequence___Black_begins_default();
	}
	
	private void effect___Initial_time_tr0() {
		exitSequence___Initial_time();
		sCIDisplay.setWhiteDisplay(10);
		
		enterSequence___Increment_Time_default();
	}
	
	private void effect___Initial_time_tr1() {
		exitSequence___Initial_time();
		setWhiteInit(getWhiteInit() + 10);
		
		enterSequence___Initial_time_default();
	}
	
	private void effect___Initial_time_tr2() {
		exitSequence___Initial_time();
		setWhiteInit(getWhiteInit() - 10);
		
		enterSequence___Initial_time_default();
	}
	
	private void effect___Initial_time_tr3() {
		exitSequence___Initial_time();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___Initial_time_tr4() {
		exitSequence___Initial_time();
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Initial_time_default();
	}
	
	private void effect___Increment_Time_tr0() {
		exitSequence___Increment_Time();
		enterSequence___Maximal_time_default();
	}
	
	private void effect___Increment_Time_tr1() {
		exitSequence___Increment_Time();
		setWhiteIncrement(getWhiteIncrement() + 1);
		
		sCIDisplay.setWhiteDisplay(sCIDisplay.getWhiteDisplay() + 1);
		
		setWhiteDisplay2(sCIDisplay.whiteDisplay);
		
		enterSequence___Increment_Time_default();
	}
	
	private void effect___Increment_Time_tr2() {
		exitSequence___Increment_Time();
		setWhiteIncrement(getWhiteIncrement() - 1);
		
		sCIDisplay.setWhiteDisplay(sCIDisplay.getWhiteDisplay() - 1);
		
		enterSequence___Increment_Time_default();
	}
	
	private void effect___Increment_Time_tr3() {
		exitSequence___Increment_Time();
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Increment_Time_default();
	}
	
	private void effect___Increment_Time_tr4() {
		exitSequence___Increment_Time();
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Increment_Time_default();
	}
	
	private void effect___Maximal_time_tr0() {
		exitSequence___Maximal_time();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___Maximal_time_tr1() {
		exitSequence___Maximal_time();
		setMaximalTime(getMaximalTime() + 60);
		
		enterSequence___Maximal_time_default();
	}
	
	private void effect___Maximal_time_tr2() {
		exitSequence___Maximal_time();
		setMaximalTime(getMaximalTime() - 60);
		
		enterSequence___Maximal_time_default();
	}
	
	private void effect___Maximal_time_tr3() {
		exitSequence___Maximal_time();
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Maximal_time_default();
	}
	
	private void effect___Maximal_time_tr4() {
		exitSequence___Maximal_time();
		react____choice_2();
	}
	
	private void effect___Ready_to_play__2__tr0() {
		exitSequence___Ready_to_play__2_();
		enterSequence___White_begins_default();
	}
	
	private void effect___Ready_to_play__2__tr1() {
		exitSequence___Ready_to_play__2_();
		sCIDisplay.setWhiteDisplay(whiteInit);
		
		sCIDisplay.setBlackDisplay(blackInit);
		
		enterSequence___White_moves_default();
	}
	
	private void effect___White_moves_lr1_lr1() {
		sCIDisplay.setWhiteDisplay(600);
	}
	
	private void effect___White_moves_lr2_lr2() {
		sCIDisplay.setBlackDisplay(600);
	}
	
	private void effect___White_moves_tr0() {
		exitSequence___White_moves();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___White_moves_tr1() {
		exitSequence___White_moves();
		enterSequence___Game_Over_default();
	}
	
	private void effect___White_moves_tr2() {
		exitSequence___White_moves();
		sCIBeeper.operationCallback.beep();
		
		sCIDisplay.setWhiteDisplay(whiteInit);
		
		sCIDisplay.setBlackDisplay(blackInit);
		
		enterSequence___Black_moves_default();
	}
	
	private void effect___White_moves_tr3() {
		exitSequence___White_moves();
		sCIDisplay.setWhiteDisplay(sCIDisplay.getWhiteDisplay() - 1);
		
		react____choice_1();
	}
	
	private void effect___Ready_to_play__1__tr0() {
		exitSequence___Ready_to_play__1_();
		enterSequence___White_begins_default();
	}
	
	private void effect___Ready_to_play__1__tr1() {
		exitSequence___Ready_to_play__1_();
		sCIDisplay.setWhiteDisplay(120);
		
		sCIDisplay.setBlackDisplay(120);
		
		enterSequence___White_moves_default();
	}
	
	private void effect___Black_moves_lr1_lr1() {
		sCIDisplay.setBlackDisplay(600);
	}
	
	private void effect___Black_moves_lr2_lr2() {
		sCIDisplay.setWhiteDisplay(600);
	}
	
	private void effect___Black_moves_tr0() {
		exitSequence___Black_moves();
		react____choice_0();
	}
	
	private void effect___Black_moves_tr1() {
		exitSequence___Black_moves();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___Black_moves_tr2() {
		exitSequence___Black_moves();
		enterSequence___Game_Over_default();
	}
	
	private void effect___Black_moves_tr3() {
		exitSequence___Black_moves();
		sCIBeeper.operationCallback.beep();
		
		sCIDisplay.setWhiteDisplay(sCIDisplay.getWhiteDisplay() + whiteDisplay2);
		
		sCIDisplay.setBlackDisplay(sCIDisplay.whiteDisplay);
		
		enterSequence___White_moves_default();
	}
	
	private void effect___White_lost_tr0() {
		exitSequence___White_lost();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___Black_lost_tr0() {
		exitSequence___Black_lost();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___Game_Over_tr0() {
		exitSequence___Game_Over();
		enterSequence___Ready_to_play__2__default();
	}
	
	private void effect___Black_begins_tr0() {
		exitSequence___Black_begins();
		enterSequence___Initial_time__2__default();
	}
	
	private void effect___Black_begins_tr1() {
		exitSequence___Black_begins();
		enterSequence___White_begins_default();
	}
	
	private void effect___Black_begins_tr2() {
		exitSequence___Black_begins();
		enterSequence___Black_begins_default();
	}
	
	private void effect___Initial_time__2__tr0() {
		exitSequence___Initial_time__2_();
		enterSequence___Increment_Time__2__default();
	}
	
	private void effect___Initial_time__2__tr1() {
		exitSequence___Initial_time__2_();
		setBlackInitBlack(getBlackInitBlack() + 10);
		
		enterSequence___Initial_time__2__default();
	}
	
	private void effect___Initial_time__2__tr2() {
		exitSequence___Initial_time__2_();
		setBlackInitBlack(getBlackInitBlack() - 10);
		
		enterSequence___Initial_time__2__default();
	}
	
	private void effect___Initial_time__2__tr3() {
		exitSequence___Initial_time__2_();
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Initial_time__2__default();
	}
	
	private void effect___Increment_Time__2__tr0() {
		exitSequence___Increment_Time__2_();
		enterSequence___Maximal_time__2__default();
	}
	
	private void effect___Increment_Time__2__tr1() {
		exitSequence___Increment_Time__2_();
		setIncrementBlack(getIncrementBlack() + 10);
		
		enterSequence___Increment_Time__2__default();
	}
	
	private void effect___Increment_Time__2__tr2() {
		exitSequence___Increment_Time__2_();
		setIncrementBlack(getIncrementBlack() - 10);
		
		enterSequence___Increment_Time__2__default();
	}
	
	private void effect___Maximal_time__2__tr0() {
		exitSequence___Maximal_time__2_();
		enterSequence___Ready_to_play__3__default();
	}
	
	private void effect___Maximal_time__2__tr1() {
		exitSequence___Maximal_time__2_();
		setMaximalTimeBlack(getMaximalTimeBlack() + 60);
		
		enterSequence___Maximal_time__2__default();
	}
	
	private void effect___Maximal_time__2__tr2() {
		exitSequence___Maximal_time__2_();
		setMaximalTimeBlack(getMaximalTimeBlack() - 60);
		
		enterSequence___Maximal_time__2__default();
	}
	
	private void effect___Ready_to_play__3__tr0() {
		exitSequence___Ready_to_play__3_();
		enterSequence___Black_begins_default();
	}
	
	private void effect___Ready_to_play__3__tr1() {
		exitSequence___Ready_to_play__3_();
		sCIDisplay.setWhiteDisplay(whiteInit);
		
		sCIDisplay.setBlackDisplay(blackInit);
		
		enterSequence___Black_moves_default();
	}
	
	private void effect____choice_0_tr1() {
		sCIDisplay.setBlackDisplay(sCIDisplay.getBlackDisplay() - 1);
		
		enterSequence___Black_moves_default();
	}
	
	private void effect____choice_0_tr0() {
		enterSequence___Black_lost_default();
	}
	
	private void effect____choice_1_tr0() {
		enterSequence___White_moves_default();
	}
	
	private void effect____choice_1_tr1() {
		sCIBeeper.operationCallback.beep();
		
		enterSequence___White_lost_default();
	}
	
	private void effect____choice_2_tr0() {
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Maximal_time_default();
	}
	
	private void effect____choice_2_tr1() {
		sCIBeeper.operationCallback.beep();
		
		enterSequence___Maximal_time_default();
	}
	
	private void effect____choice_2_tr2() {
		enterSequence___Maximal_time_default();
	}
	
	/* Entry action for state 'White begins'. */
	private void entryAction___White_begins() {
		sCIDisplay.setText("White begins");
	}
	
	/* Entry action for state 'Initial time'. */
	private void entryAction___Initial_time() {
		sCIDisplay.setWhiteDisplay(whiteInit);
		
		setBlackInit(whiteInit);
		
		sCIDisplay.setBlackDisplay(blackInit);
		
		sCIDisplay.setText("Initial time");
	}
	
	/* Entry action for state 'Increment Time'. */
	private void entryAction___Increment_Time() {
		sCIDisplay.setText("Increment time");
	}
	
	/* Entry action for state 'Maximal time'. */
	private void entryAction___Maximal_time() {
		sCIDisplay.setText("Maximal time");
		
		sCIDisplay.setWhiteDisplay(maximalTime);
	}
	
	/* Entry action for state 'Ready to play (2)'. */
	private void entryAction___Ready_to_play__2_() {
		sCIDisplay.setText("Ready to play");
	}
	
	/* Entry action for state 'White moves'. */
	private void entryAction___White_moves() {
		timer.setTimer(this, 0, 1 * 1000, true);
		
		sCIDisplay.setText("White moves");
	}
	
	/* Entry action for state 'Ready to play (1)'. */
	private void entryAction___Ready_to_play__1_() {
		sCIDisplay.setText("Ready to play");
	}
	
	/* Entry action for state 'Black moves'. */
	private void entryAction___Black_moves() {
		timer.setTimer(this, 1, 1 * 1000, true);
		
		sCIDisplay.setText("Black moves");
	}
	
	/* Entry action for state 'White lost'. */
	private void entryAction___White_lost() {
		sCIDisplay.setText("White flag fallen");
	}
	
	/* Entry action for state 'Black lost'. */
	private void entryAction___Black_lost() {
		sCIDisplay.setText("Black flag fallen");
	}
	
	/* Entry action for state 'Game Over'. */
	private void entryAction___Game_Over() {
		sCIDisplay.setText("Game Over");
	}
	
	/* Entry action for state 'Black begins'. */
	private void entryAction___Black_begins() {
		sCIDisplay.setText("Black begins");
	}
	
	/* Entry action for state 'Initial time (2)'. */
	private void entryAction___Initial_time__2_() {
		sCIDisplay.setBlackDisplay(blackInitBlack);
	}
	
	/* Entry action for state 'Ready to play (3)'. */
	private void entryAction___Ready_to_play__3_() {
		sCIDisplay.setText("Ready to play");
	}
	
	/* Exit action for state 'White moves'. */
	private void exitAction___White_moves() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Black moves'. */
	private void exitAction___Black_moves() {
		timer.unsetTimer(this, 1);
	}
	
	/* 'default' enter sequence for state White begins */
	private void enterSequence___White_begins_default() {
		entryAction___White_begins();
		nextStateIndex = 0;
		stateVector[0] = State.__White_begins;
	}
	
	/* 'default' enter sequence for state Initial time */
	private void enterSequence___Initial_time_default() {
		entryAction___Initial_time();
		nextStateIndex = 0;
		stateVector[0] = State.__Initial_time;
	}
	
	/* 'default' enter sequence for state Increment Time */
	private void enterSequence___Increment_Time_default() {
		entryAction___Increment_Time();
		nextStateIndex = 0;
		stateVector[0] = State.__Increment_Time;
	}
	
	/* 'default' enter sequence for state Maximal time */
	private void enterSequence___Maximal_time_default() {
		entryAction___Maximal_time();
		nextStateIndex = 0;
		stateVector[0] = State.__Maximal_time;
	}
	
	/* 'default' enter sequence for state Ready to play (2) */
	private void enterSequence___Ready_to_play__2__default() {
		entryAction___Ready_to_play__2_();
		nextStateIndex = 0;
		stateVector[0] = State.__Ready_to_play__2_;
	}
	
	/* 'default' enter sequence for state White moves */
	private void enterSequence___White_moves_default() {
		entryAction___White_moves();
		nextStateIndex = 0;
		stateVector[0] = State.__White_moves;
	}
	
	/* 'default' enter sequence for state Ready to play (1) */
	private void enterSequence___Ready_to_play__1__default() {
		entryAction___Ready_to_play__1_();
		nextStateIndex = 0;
		stateVector[0] = State.__Ready_to_play__1_;
	}
	
	/* 'default' enter sequence for state Black moves */
	private void enterSequence___Black_moves_default() {
		entryAction___Black_moves();
		nextStateIndex = 0;
		stateVector[0] = State.__Black_moves;
	}
	
	/* 'default' enter sequence for state White lost */
	private void enterSequence___White_lost_default() {
		entryAction___White_lost();
		nextStateIndex = 0;
		stateVector[0] = State.__White_lost;
	}
	
	/* 'default' enter sequence for state Black lost */
	private void enterSequence___Black_lost_default() {
		entryAction___Black_lost();
		nextStateIndex = 0;
		stateVector[0] = State.__Black_lost;
	}
	
	/* 'default' enter sequence for state Game Over */
	private void enterSequence___Game_Over_default() {
		entryAction___Game_Over();
		nextStateIndex = 0;
		stateVector[0] = State.__Game_Over;
	}
	
	/* 'default' enter sequence for state Black begins */
	private void enterSequence___Black_begins_default() {
		entryAction___Black_begins();
		nextStateIndex = 0;
		stateVector[0] = State.__Black_begins;
	}
	
	/* 'default' enter sequence for state Initial time (2) */
	private void enterSequence___Initial_time__2__default() {
		entryAction___Initial_time__2_();
		nextStateIndex = 0;
		stateVector[0] = State.__Initial_time__2_;
	}
	
	/* 'default' enter sequence for state Increment Time (2) */
	private void enterSequence___Increment_Time__2__default() {
		nextStateIndex = 0;
		stateVector[0] = State.__Increment_Time__2_;
	}
	
	/* 'default' enter sequence for state Maximal time (2) */
	private void enterSequence___Maximal_time__2__default() {
		nextStateIndex = 0;
		stateVector[0] = State.__Maximal_time__2_;
	}
	
	/* 'default' enter sequence for state Ready to play (3) */
	private void enterSequence___Ready_to_play__3__default() {
		entryAction___Ready_to_play__3_();
		nextStateIndex = 0;
		stateVector[0] = State.__Ready_to_play__3_;
	}
	
	/* 'default' enter sequence for region ; */
	private void enterSequence___default() {
		react____entry_Default();
	}
	
	/* Default exit sequence for state White begins */
	private void exitSequence___White_begins() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Initial time */
	private void exitSequence___Initial_time() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Increment Time */
	private void exitSequence___Increment_Time() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Maximal time */
	private void exitSequence___Maximal_time() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Ready to play (2) */
	private void exitSequence___Ready_to_play__2_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state White moves */
	private void exitSequence___White_moves() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction___White_moves();
	}
	
	/* Default exit sequence for state Ready to play (1) */
	private void exitSequence___Ready_to_play__1_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Black moves */
	private void exitSequence___Black_moves() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction___Black_moves();
	}
	
	/* Default exit sequence for state White lost */
	private void exitSequence___White_lost() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Black lost */
	private void exitSequence___Black_lost() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Game Over */
	private void exitSequence___Game_Over() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Black begins */
	private void exitSequence___Black_begins() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Initial time (2) */
	private void exitSequence___Initial_time__2_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Increment Time (2) */
	private void exitSequence___Increment_Time__2_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Maximal time (2) */
	private void exitSequence___Maximal_time__2_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Ready to play (3) */
	private void exitSequence___Ready_to_play__3_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region ; */
	private void exitSequence__() {
		switch (stateVector[0]) {
		case __White_begins:
			exitSequence___White_begins();
			break;
		case __Initial_time:
			exitSequence___Initial_time();
			break;
		case __Increment_Time:
			exitSequence___Increment_Time();
			break;
		case __Maximal_time:
			exitSequence___Maximal_time();
			break;
		case __Ready_to_play__2_:
			exitSequence___Ready_to_play__2_();
			break;
		case __White_moves:
			exitSequence___White_moves();
			break;
		case __Ready_to_play__1_:
			exitSequence___Ready_to_play__1_();
			break;
		case __Black_moves:
			exitSequence___Black_moves();
			break;
		case __White_lost:
			exitSequence___White_lost();
			break;
		case __Black_lost:
			exitSequence___Black_lost();
			break;
		case __Game_Over:
			exitSequence___Game_Over();
			break;
		case __Black_begins:
			exitSequence___Black_begins();
			break;
		case __Initial_time__2_:
			exitSequence___Initial_time__2_();
			break;
		case __Increment_Time__2_:
			exitSequence___Increment_Time__2_();
			break;
		case __Maximal_time__2_:
			exitSequence___Maximal_time__2_();
			break;
		case __Ready_to_play__3_:
			exitSequence___Ready_to_play__3_();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state White begins. */
	private void react___White_begins() {
		if (check___White_begins_tr0_tr0()) {
			effect___White_begins_tr0();
		} else {
			if (check___White_begins_tr1_tr1()) {
				effect___White_begins_tr1();
			}
		}
	}
	
	/* The reactions of state Initial time. */
	private void react___Initial_time() {
		if (check___Initial_time_tr0_tr0()) {
			effect___Initial_time_tr0();
		} else {
			if (check___Initial_time_tr1_tr1()) {
				effect___Initial_time_tr1();
			} else {
				if (check___Initial_time_tr2_tr2()) {
					effect___Initial_time_tr2();
				} else {
					if (check___Initial_time_tr3_tr3()) {
						effect___Initial_time_tr3();
					} else {
						if (check___Initial_time_tr4_tr4()) {
							effect___Initial_time_tr4();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Increment Time. */
	private void react___Increment_Time() {
		if (check___Increment_Time_tr0_tr0()) {
			effect___Increment_Time_tr0();
		} else {
			if (check___Increment_Time_tr1_tr1()) {
				effect___Increment_Time_tr1();
			} else {
				if (check___Increment_Time_tr2_tr2()) {
					effect___Increment_Time_tr2();
				} else {
					if (check___Increment_Time_tr3_tr3()) {
						effect___Increment_Time_tr3();
					} else {
						if (check___Increment_Time_tr4_tr4()) {
							effect___Increment_Time_tr4();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Maximal time. */
	private void react___Maximal_time() {
		if (check___Maximal_time_tr0_tr0()) {
			effect___Maximal_time_tr0();
		} else {
			if (check___Maximal_time_tr1_tr1()) {
				effect___Maximal_time_tr1();
			} else {
				if (check___Maximal_time_tr2_tr2()) {
					effect___Maximal_time_tr2();
				} else {
					if (check___Maximal_time_tr3_tr3()) {
						effect___Maximal_time_tr3();
					} else {
						if (check___Maximal_time_tr4_tr4()) {
							effect___Maximal_time_tr4();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Ready to play (2). */
	private void react___Ready_to_play__2_() {
		if (check___Ready_to_play__2__tr0_tr0()) {
			effect___Ready_to_play__2__tr0();
		} else {
			if (check___Ready_to_play__2__tr1_tr1()) {
				effect___Ready_to_play__2__tr1();
			}
		}
	}
	
	/* The reactions of state White moves. */
	private void react___White_moves() {
		if (check___White_moves_tr0_tr0()) {
			effect___White_moves_tr0();
		} else {
			if (check___White_moves_tr1_tr1()) {
				effect___White_moves_tr1();
			} else {
				if (check___White_moves_tr2_tr2()) {
					effect___White_moves_tr2();
				} else {
					if (check___White_moves_tr3_tr3()) {
						effect___White_moves_tr3();
					} else {
						if (check___White_moves_lr1_lr1()) {
							effect___White_moves_lr1_lr1();
						}
						if (check___White_moves_lr2_lr2()) {
							effect___White_moves_lr2_lr2();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state Ready to play (1). */
	private void react___Ready_to_play__1_() {
		if (check___Ready_to_play__1__tr0_tr0()) {
			effect___Ready_to_play__1__tr0();
		} else {
			if (check___Ready_to_play__1__tr1_tr1()) {
				effect___Ready_to_play__1__tr1();
			}
		}
	}
	
	/* The reactions of state Black moves. */
	private void react___Black_moves() {
		if (check___Black_moves_tr0_tr0()) {
			effect___Black_moves_tr0();
		} else {
			if (check___Black_moves_tr1_tr1()) {
				effect___Black_moves_tr1();
			} else {
				if (check___Black_moves_tr2_tr2()) {
					effect___Black_moves_tr2();
				} else {
					if (check___Black_moves_tr3_tr3()) {
						effect___Black_moves_tr3();
					} else {
						if (check___Black_moves_lr1_lr1()) {
							effect___Black_moves_lr1_lr1();
						}
						if (check___Black_moves_lr2_lr2()) {
							effect___Black_moves_lr2_lr2();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state White lost. */
	private void react___White_lost() {
		if (check___White_lost_tr0_tr0()) {
			effect___White_lost_tr0();
		}
	}
	
	/* The reactions of state Black lost. */
	private void react___Black_lost() {
		if (check___Black_lost_tr0_tr0()) {
			effect___Black_lost_tr0();
		}
	}
	
	/* The reactions of state Game Over. */
	private void react___Game_Over() {
		if (check___Game_Over_tr0_tr0()) {
			effect___Game_Over_tr0();
		}
	}
	
	/* The reactions of state Black begins. */
	private void react___Black_begins() {
		if (check___Black_begins_tr0_tr0()) {
			effect___Black_begins_tr0();
		} else {
			if (check___Black_begins_tr1_tr1()) {
				effect___Black_begins_tr1();
			} else {
				if (check___Black_begins_tr2_tr2()) {
					effect___Black_begins_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Initial time (2). */
	private void react___Initial_time__2_() {
		if (check___Initial_time__2__tr0_tr0()) {
			effect___Initial_time__2__tr0();
		} else {
			if (check___Initial_time__2__tr1_tr1()) {
				effect___Initial_time__2__tr1();
			} else {
				if (check___Initial_time__2__tr2_tr2()) {
					effect___Initial_time__2__tr2();
				} else {
					if (check___Initial_time__2__tr3_tr3()) {
						effect___Initial_time__2__tr3();
					}
				}
			}
		}
	}
	
	/* The reactions of state Increment Time (2). */
	private void react___Increment_Time__2_() {
		if (check___Increment_Time__2__tr0_tr0()) {
			effect___Increment_Time__2__tr0();
		} else {
			if (check___Increment_Time__2__tr1_tr1()) {
				effect___Increment_Time__2__tr1();
			} else {
				if (check___Increment_Time__2__tr2_tr2()) {
					effect___Increment_Time__2__tr2();
				}
			}
		}
	}
	
	/* The reactions of state Maximal time (2). */
	private void react___Maximal_time__2_() {
		if (check___Maximal_time__2__tr0_tr0()) {
			effect___Maximal_time__2__tr0();
		} else {
			if (check___Maximal_time__2__tr1_tr1()) {
				effect___Maximal_time__2__tr1();
			} else {
				if (check___Maximal_time__2__tr2_tr2()) {
					effect___Maximal_time__2__tr2();
				}
			}
		}
	}
	
	/* The reactions of state Ready to play (3). */
	private void react___Ready_to_play__3_() {
		if (check___Ready_to_play__3__tr0_tr0()) {
			effect___Ready_to_play__3__tr0();
		} else {
			if (check___Ready_to_play__3__tr1_tr1()) {
				effect___Ready_to_play__3__tr1();
			}
		}
	}
	
	/* The reactions of state null. */
	private void react____choice_0() {
		if (check____choice_0_tr1_tr1()) {
			effect____choice_0_tr1();
		} else {
			effect____choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react____choice_1() {
		if (check____choice_1_tr0_tr0()) {
			effect____choice_1_tr0();
		} else {
			effect____choice_1_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react____choice_2() {
		if (check____choice_2_tr0_tr0()) {
			effect____choice_2_tr0();
		} else {
			if (check____choice_2_tr1_tr1()) {
				effect____choice_2_tr1();
			} else {
				effect____choice_2_tr2();
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react____entry_Default() {
		enterSequence___Ready_to_play__1__default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case __White_begins:
				react___White_begins();
				break;
			case __Initial_time:
				react___Initial_time();
				break;
			case __Increment_Time:
				react___Increment_Time();
				break;
			case __Maximal_time:
				react___Maximal_time();
				break;
			case __Ready_to_play__2_:
				react___Ready_to_play__2_();
				break;
			case __White_moves:
				react___White_moves();
				break;
			case __Ready_to_play__1_:
				react___Ready_to_play__1_();
				break;
			case __Black_moves:
				react___Black_moves();
				break;
			case __White_lost:
				react___White_lost();
				break;
			case __Black_lost:
				react___Black_lost();
				break;
			case __Game_Over:
				react___Game_Over();
				break;
			case __Black_begins:
				react___Black_begins();
				break;
			case __Initial_time__2_:
				react___Initial_time__2_();
				break;
			case __Increment_Time__2_:
				react___Increment_Time__2_();
				break;
			case __Maximal_time__2_:
				react___Maximal_time__2_();
				break;
			case __Ready_to_play__3_:
				react___Ready_to_play__3_();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
