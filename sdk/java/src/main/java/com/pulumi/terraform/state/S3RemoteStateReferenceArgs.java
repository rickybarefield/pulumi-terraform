// Copyright 2016-2024, Pulumi Corporation.

package com.pulumi.terraform.state;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

/**
 * The configuration options for a Terraform Remote State stored in the S3 backend.
 */
@Getter
public class S3RemoteStateReferenceArgs extends RemoteStateReferenceArgs {

    /**
     * The name of the S3 bucket.
     */
    @Import(name = "bucket", required = true)
    private final Output<String> bucket;

    /**
     * The path to the state file inside the bucket. When using a non-default workspace,
     * the state path will be `/workspace_key_prefix/workspace_name/key`.
     */
    @Import(name = "key", required = true)
    private final Output<String> key;

    /**
     * The region of the S3 bucket. Also sourced from `AWS_DEFAULT_REGION` in the environment, if unset.
     */
    @Import(name = "region")
    private final Output<String> region;

    /**
     * A custom endpoint for the S3 API. Also sourced from `AWS_S3_ENDPOINT` in the environment, if unset.
     */
    @Import(name = "endpoint")
    private final Output<String> endpoint;

    /**
     * AWS Access Key. Sourced from the standard credentials pipeline, if unset.
     */
    @Import(name = "accessKey")
    private final Output<String> accessKey;

    /**
     * AWS Secret Access Key. Sourced from the standard credentials pipeline, if unset.
     */
    @Import(name = "secretKey")
    private final Output<String> secretKey;

    /**
     * The AWS profile name as set in the shared credentials file.
     */
    @Import(name = "profile")
    private final Output<String> profile;

    /**
     * The path to the shared credentials file. If this is not set and a profile is
     * specified, `~/.aws/credentials` will be used by default.
     */
    @Import(name = "sharedCredentialsFile")
    private final Output<String> sharedCredentialsFile;

    /**
     * An MFA token. Sourced from the `AWS_SESSION_TOKEN` in the environment variable if needed and unset.
     */
    @Import(name = "token")
    private final Output<String> token;

    /**
     * The ARN of an IAM Role to be assumed in order to read the state from S3.
     */
    @Import(name = "roleArn")
    private final Output<String> roleArn;

    /**
     * The external ID to use when assuming the IAM role.
     */
    @Import(name = "externalId")
    private final Output<String> externalId;

    /**
     * The session name to use when assuming the IAM role.
     */
    @Import(name = "sessionName")
    private final Output<String> sessionName;

    /**
     * The prefix applied to the state path inside the bucket. This is only relevant when
     * using a non-default workspace, and defaults to `env:`.
     */
    @Import(name = "workspaceKeyPrefix")
    private final Output<String> workspaceKeyPrefix;

    /**
     * A custom endpoint for the IAM API. Sourced from `AWS_IAM_ENDPOINT`, if unset.
     */
    @Import(name = "iamEndpoint")
    private final Output<String> iamEndpoint;

    /**
     * A custom endpoint for the STS API. Sourced from `AWS_STS_ENDPOINT`, if unset.
     */
    @Import(name = "stsEndpoint")
    private final Output<String> stsEndpoint;

    /**
     * Skip the credentials validation via STS API.
     */
    @Import(name = "skipCredentialsValidation")
    private final Output<Boolean> skipCredentialsValidation;

    /**
     * Skip static validation of region name.
     */
    @Import(name = "skipRegionValidation")
    private final Output<Boolean> skipRegionValidation;

    /**
     * Skip the AWS Metadata API check.
     */
    @Import(name = "skipMetadataApiCheck")
    private final Output<Boolean> skipMetadataApiCheck;

    /**
     * Force s3 to use path style api.
     */
    @Import(name = "forcePathStyle")
    private final Output<Boolean> forcePathStyle;

    /**
     * The Terraform workspace from which to read state.
     */
    @Import(name = "workspace")
    private final Output<String> workspace;


    @Builder
    public S3RemoteStateReferenceArgs(Output<String> bucket, Output<String> key, Output<String> region, Output<String> endpoint, Output<String> accessKey, Output<String> secretKey, Output<String> profile, Output<String> sharedCredentialsFile, Output<String> token, Output<String> roleArn, Output<String> externalId, Output<String> sessionName, Output<String> workspaceKeyPrefix, Output<String> iamEndpoint, Output<String> stsEndpoint, Output<Boolean> skipCredentialsValidation, Output<Boolean> skipRegionValidation, Output<Boolean> skipMetadataApiCheck, Output<Boolean> forcePathStyle, Output<String> workspace) {

        super(Output.of("s3"));
        this.bucket = bucket;
        this.key = key;
        this.region = region;
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.profile = profile;
        this.sharedCredentialsFile = sharedCredentialsFile;
        this.token = token;
        this.roleArn = roleArn;
        this.externalId = externalId;
        this.sessionName = sessionName;
        this.workspaceKeyPrefix = workspaceKeyPrefix;
        this.iamEndpoint = iamEndpoint;
        this.stsEndpoint = stsEndpoint;
        this.skipCredentialsValidation = skipCredentialsValidation;
        this.skipRegionValidation = skipRegionValidation;
        this.skipMetadataApiCheck = skipMetadataApiCheck;
        this.forcePathStyle = forcePathStyle;
        this.workspace = workspace;
    }

    public static class S3RemoteStateReferenceArgsBuilder {

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder bucket(String bucket) {

            this.bucket = Output.of(bucket);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder key(String key) {

            this.key = Output.of(key);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder region(String region) {

            this.region = Output.of(region);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder endpoint(String endpoint) {

            this.endpoint = Output.of(endpoint);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder accessKey(String accessKey) {

            this.accessKey = Output.of(accessKey);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder secretKey(String secretKey) {

            this.secretKey = Output.of(secretKey);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder profile(String profile) {

            this.profile = Output.of(profile);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder sharedCredentialsFile(String sharedCredentialsFile) {

            this.sharedCredentialsFile = Output.of(sharedCredentialsFile);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder token(String token) {

            this.token = Output.of(token);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder roleArn(String roleArn) {

            this.roleArn = Output.of(roleArn);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder externalId(String externalId) {

            this.externalId = Output.of(externalId);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder sessionName(String sessionName) {

            this.sessionName = Output.of(sessionName);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder workspaceKeyPrefix(String workspaceKeyPrefix) {

            this.workspaceKeyPrefix = Output.of(workspaceKeyPrefix);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder iamEndpoint(String iamEndpoint) {

            this.iamEndpoint = Output.of(iamEndpoint);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder stsEndpoint(String stsEndpoint) {

            this.stsEndpoint = Output.of(stsEndpoint);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder skipCredentialsValidation(Boolean skipCredentialsValidation) {

            this.skipCredentialsValidation = Output.of(skipCredentialsValidation);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder skipRegionValidation(Boolean skipRegionValidation) {

            this.skipRegionValidation = Output.of(skipRegionValidation);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder skipMetadataApiCheck(Boolean skipMetadataApiCheck) {

            this.skipMetadataApiCheck = Output.of(skipMetadataApiCheck);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder forcePathStyle(Boolean forcePathStyle) {

            this.forcePathStyle = Output.of(forcePathStyle);
            return this;
        }

        @Tolerate
        public S3RemoteStateReferenceArgsBuilder workspace(String workspace) {

            this.workspace = Output.of(workspace);
            return this;
        }

    }
}
