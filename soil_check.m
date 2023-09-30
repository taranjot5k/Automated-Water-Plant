function [state] = soil_check(v)
reallyDryValue= 3.4;
dampValue= 3.3;
wetValue=2.5; 
if(v > reallyDryValue)
    state = ('plant is dry');
elseif (v > dampValue)
  state = ('plant is sort of wet');
elseif (v >= wetValue)
   state = ('plant is wet');
end
disp(v)
end
