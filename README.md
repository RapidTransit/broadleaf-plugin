# Broadleaf Intellij Plugin

**Immediate Goals**
- Add Thymeleaf `th:* ` namespace ... Working But not Tested
- For AdminPresentationAttributes
    - Custom Inspections ... **10%** (Some are tested, some I need clarification on)
    - Reference Fields ... **10%** (Just Basic Support on String Literals so far, no Extended Property Navigation yet)
    - Auto Complete on Fields ... **10%** (Basically this is tied into the above)
- Tool Window
    - View All Extension Handlers and Jump To ... **10%** (Can View the Stuff, And Jump To, it ain't pretty)
    - View All Workflows **0%**
    
**Additional Todo**
- Inspection for `getSectionKey()` for Admin Controllers
- Add Field References to CustomPersistenceHandlers
- Inspection for `canHandle*(**)` style methods to make sure the Action is Implemented
- Inspection for `ExtensionResult` Handlers do not return null
- Add AdminOverride Inspections and Reference Providers
- Add File Templates
- Add Something like `.editor_config` styled file so we can have some more thorough inspections

Running: `gradle runIde`

