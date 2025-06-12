This is a well-structured beginner Java project that demonstrates good understanding of classes, objects, and basic OOP principles. The code is functional and shows that you're thinking about separation of concerns.

**OVERALL: PASSED**

 Minor Tweaks:

* Variable name `user_action` should be `userAction` (camelCase convention)
* Method `accessOrReleaseLocker()` does two different things (violates Single Responsibility). In general, any time you have the urge to write "or" or "and" in a method name, you're probably violating SRP.
* Method `isValidLockerID()` returns `ResultStr` but name suggests a boolean return. This is nitpicking, but for a Result type this might be better named as `validateLockerPIN()`.