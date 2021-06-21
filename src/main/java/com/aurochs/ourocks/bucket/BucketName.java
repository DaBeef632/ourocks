package com.aurochs.ourocks.bucket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum BucketName {
    PROFILE_IMAGE("aurouchs-ourocks-image-uploads-123");

    private final String bucketName;
}
