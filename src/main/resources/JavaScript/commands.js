RUNTIME = RunTime.get();

USEJSON = false;

jsonOn = function() {
	USEJSON = true;
	Debug.log(3, "JSON: Now returning JSONized objects");
};

jsonOff = function() {
	USEJSON = false;
	Debug.log(3, "JSON: Now returning normal objects");
};

isNull = function(aObj) {
	if (!Commands.isJSON(aObj)) {
		return aObj == null;
	}
	return Commands.fromJSON(aObj) == null;
};

json = function(aObj) {
	if (!Commands.isJSON(aObj)) {
		return aObj;
	}
	return Commands.fromJSON(aObj);
};

getArgsForJ = function(args) {
  var jargs;
  if (Commands.isNashorn()) {
    jargs = Java.to(args);
  } else {
    jargs = java.lang.reflect.Array.newInstance(java.lang.Object, args.length);
    for(n = 0; n < args.length; n++) {
      jargs[n] = args[n];
    }
  }
	return jargs;
};

makeRetVal = function(aObj) {
  Commands.restoreUsed();
  return makeRetValDo(aObj);
};

makeRetValDo = function(aObj) {
  if (!USEJSON) {
		return aObj;
	} else {
		try {
			return aObj.toJSON();
		} catch (ex) {
		}
		try {
			return "[\"" + aObj.getClass().getName() + ", \"" + aObj.toString + "\"]";
		} catch (ex) {
			return "[\"NULL\"]";
		}
	}
};

run = function() {
  if (arguments.length < 1) {
    return;
  }
  jargs = getArgsForJ(arguments);
  if (arguments.length > 1) {
    Runner.run(jargs[0]);    
  } else {
    Runner.run(jargs[0]);
  }
}

use = function() {
  return makeRetValDo(Commands.call("use", getArgsForJ(arguments)));
};

use1 = function() {
  return makeRetValDo(Commands.call("use1", getArgsForJ(arguments)));
};

wait = function() {
  return makeRetVal(Commands.call("wait", getArgsForJ(arguments)));
};

waitVanish = function() {
  return makeRetVal(Commands.call("waitVanish", getArgsForJ(arguments)));
};

exists = function() {
  return makeRetVal(Commands.call("exists", getArgsForJ(arguments)));
};

click = function() {
  return makeRetVal(Commands.call("click", getArgsForJ(arguments)));
};

doubleClick = function() {
  return makeRetVal(Commands.call("doubleClick", getArgsForJ(arguments)));
};

rightClick = function() {
  return makeRetVal(Commands.call("rightClick", getArgsForJ(arguments)));
};

hover = function() {
  return makeRetVal(Commands.call("hover", getArgsForJ(arguments)));
};

type = function() {
  return makeRetVal(Commands.call("type", getArgsForJ(arguments)));
};

write = function() {
  return makeRetVal(Commands.call("write", getArgsForJ(arguments)));
};

paste = function() {
  return makeRetVal(Commands.call("paste", getArgsForJ(arguments)));
};

closeApp = function() {
	if (RunTime.get().runningMac) {
		write("#M.q");
	} else if (RunTime.get().runningWindows) {
		write("#A.#F4.");
	} else {
		write("#C.q");
	};
};

closeBrowserWindow = function() {
	if (RunTime.get().runningMac) {
		write("#M.w");
	} else {
		write("#C.w");
	};
};
