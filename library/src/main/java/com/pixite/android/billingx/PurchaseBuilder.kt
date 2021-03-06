package com.pixite.android.billingx

import com.android.billingclient.api.Purchase
import org.json.JSONObject

data class PurchaseBuilder(
    val orderId: String? = null,
    val packageName: String? = null,
    val sku: String,
    val purchaseTime: Long,
    val purchaseToken: String,
    val signature: String,
    val isAutoRenewing: Boolean? = null,
    val developerPayload: Map<String, Any>? = null
) {

  fun build(): Purchase {
    val json = JSONObject()
    orderId?.let { json.put("orderId", it) }
    packageName?.let { json.put("packageName", it) }
    json.put("productId", sku)
    json.put("purchaseTime", purchaseTime)
    json.put("purchaseToken", purchaseToken)
    isAutoRenewing?.let { json.put("autoRenewing", it) }
    developerPayload?.let { json.put("developerPayload", it) }
    return Purchase(json.toString(), signature)
  }
}