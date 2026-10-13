# Java SDK Contract Fixes Design

## Goal

Correct the Java types exposed by the newly added endpoints, make the demo-fund request type-safe, identify obsolete endpoints in the public API, and add regression tests for the wire contract.

## Scope

- Change the Auto Savings `coins` parameter from `List<Object>` to `List<String>` in the synchronous client, asynchronous client, implementations, and Retrofit service.
- Change `SmallAssetQuoteRequest.fromCoinList` from `List<Object>` to `List<String>`.
- Add a request-item bean containing `coin` and `amountStr`, and use `List<...>` of that type in `UtaDemoApplyMoneyRequest`.
- Mark `transferSubMemberSave` and `insLoanEnsureTokens` as deprecated throughout the public synchronous and asynchronous interfaces, implementations, and Retrofit service. Keep them functional for compatibility.
- Update the changelog to describe the two obsolete endpoints as deprecated compatibility APIs.

## Compatibility

The affected APIs were introduced only on this branch and have not been released. Replacing `Object` with documented element types therefore fixes the pending API contract without breaking a published version. Deprecated endpoints remain callable.

## Tests

- Compile-time/reflection assertions verify the documented generic types across public and Retrofit interfaces.
- Retrofit request inspection verifies Auto Savings uses repeated query keys: `coins=BTC&coins=ETH`.
- Jackson serialization verifies the small-asset and demo-fund request JSON shapes.
- Reflection verifies obsolete public methods carry `@Deprecated`.
- The complete Maven test suite and package build must pass on JDK 11.

## Out of Scope

- Changing generic HTTP handling for an empty 404 response.
- Calling state-changing testnet endpoints.
- Refactoring existing response types or unrelated endpoint APIs.
