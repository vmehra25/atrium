package ch.tutteli.atrium.specs.integration

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.specs.*
import ch.tutteli.atrium.translations.DescriptionComparableAssertion
import ch.tutteli.atrium.translations.DescriptionIterableAssertion
import org.spekframework.spek2.dsl.Root

abstract class IterableToContainEntriesSpecBase(
    spec: Root.() -> Unit
) : IterableToContainSpecBase(spec) {
    init {
        toBeLessThanFun = Expect<Double>::toBeLessThan.name
        toBeGreaterThanFun = Expect<Double>::toBeGreaterThan.name
        toEqualFun = fun1<Double, Double>(Expect<Double>::toEqual).name
    }

    companion object {
        var toBeLessThanFun = ""
        var toBeGreaterThanFun = ""
        var toEqualFun = ""
        val anElementWhich = DescriptionIterableAssertion.AN_ELEMENT_WHICH.getDefault()
        val toBeLessThanDescr = DescriptionComparableAssertion.IS_LESS_THAN.getDefault()
        val toBeGreaterThanDescr = DescriptionComparableAssertion.IS_GREATER_THAN.getDefault()


        //@formatter:off
        val featureSuccess = "$indentRootBulletPoint$indentListBulletPoint\\Q$successfulBulletPoint$featureArrow\\E"
        val featureFailing = "$indentRootBulletPoint$indentListBulletPoint\\Q$failingBulletPoint$featureArrow\\E"
        val isAfterFailing = "$indentRootBulletPoint$indentListBulletPoint$indentFailingBulletPoint$indentFeatureArrow\\Q$featureBulletPoint\\E$isDescr"
        val isAfterSuccess = "$indentRootBulletPoint$indentListBulletPoint$indentSuccessfulBulletPoint$indentFeatureArrow\\Q$featureBulletPoint\\E$isDescr"
        val afterExplanatory = "$indentRootBulletPoint$indentListBulletPoint$indentSuccessfulBulletPoint\\Q$explanatoryBulletPoint\\E"
        //@formatter:on

    }
}
